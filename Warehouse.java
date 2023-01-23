package Application;

import Application.vehicles.*;
import Application.cargo.*;

class Warehouse {

    private String warehouseLocation;
    private final int maxCapacity = 1000; // i made it final for now. its easier to work with 
    private int currentSpace;
    private Transport[] transport = {new Truck(), new Ship(), new Airplane()};
    private Cargo[] materials = {new Wood(), new Iron(), new Lego()};
    private static double budget = 100_000.0; // static because there is one budget to manage 3 warehouses. for start 100k, but we can change

    // @@ make local money, add method loanMoney();

    //constructor with name as parameter
    public Warehouse(String name) {
        this.warehouseLocation = name;
        this.currentSpace = this.maxCapacity; // by default created warehouse is empty so current space = maxCap
    }


    // set current space based on data
    // this method is private, only this class can use it for own calculation
    private void initSpace() {
        this.currentSpace = this.maxCapacity - materials[0].getWeight() - materials[1].getWeight() - materials[2].getWeight();
    }


    // this method will take target(one of those 3 type of cargo)
    // and add new amount to this target
    // after that will update our free space in warehouse, based of new data(new amount of cargo)
    // this method is private, only this class can use it for own calculation
    private void updateData(int addedAmount, Cargo target, double operatePrize, double extraCost) {

        // @@ set sell or buy prize

        //update the budget
        Warehouse.budget -= ((addedAmount * operatePrize) + extraCost);

        // update amount in target (in cargo this is called weight)
        target.addWeight(addedAmount);

        // update free space based on new data
        initSpace();

    }

    public Cargo[] getMaterials() {
        return materials;
    }

    public Transport[] getTransport() {
        return transport;
    }

    // this method will fill your warehouse
    public void fillWarehouse(UI ui) {
        Cargo selectedCargo = ui.selectCargo();
        String selectedCargoName = selectedCargo.getClass().getSimpleName();

        while (true) {
            int selectedAmount = ui.selectAmount();

            if (selectedAmount == 0) return;

            double cargoPricePerTonne = 0;
            if (selectedCargoName.equals("Wood")) cargoPricePerTonne = Wood.buyValue;
            else if (selectedCargoName.equals("Iron")) cargoPricePerTonne = Iron.buyValue;
            else if (selectedCargoName.equals("Lego")) cargoPricePerTonne = Lego.buyValue;

            if (this.currentSpace - selectedAmount < 0) {
                System.out.println("You only have space for " + this.currentSpace + " more tonnes in this warehouse, please input another amount.");
            } else if (Warehouse.budget - (selectedAmount * cargoPricePerTonne) < 0) {
                System.out.println("Your budget does not allow you to buy this much cargo. Please input another amount.");
            } else {
                updateData(selectedAmount, selectedCargo, cargoPricePerTonne, 0);
                System.out.println("You have bought " + selectedAmount + " tonnes of " + selectedCargoName +
                        " for a total of €" + (selectedAmount * cargoPricePerTonne));
                break;
            }
        }
    }


    public void sellCargo(UI ui) {
        Cargo selectedCargo = ui.selectCargo();
        String selectedCargoName = selectedCargo.getClass().getSimpleName();

        while (true) {
            int selectedAmount = ui.selectAmount();

            if (selectedAmount == 0) return;

            if (selectedAmount > selectedCargo.getWeight()) {
                System.out.println("You only have " + selectedCargo.getWeight() + " tonnes of " +
                        selectedCargoName + ". Please input a lower amount.");
                continue;
            }

            double cargoPricePerTonne = 0;
            if (selectedCargoName.equals("Wood")) cargoPricePerTonne = Wood.sellValue;
            else if (selectedCargoName.equals("Iron")) cargoPricePerTonne = Iron.sellValue;
            else if (selectedCargoName.equals("Lego")) cargoPricePerTonne = Lego.sellValue;

            Transport selectedTransport = ui.selectTransport();
            double transportCost = selectedTransport.rentPrize(selectedAmount);
            double revenue = selectedAmount * cargoPricePerTonne;
            double profit = revenue - transportCost;

            System.out.println(selectedAmount + " tonnes of " + selectedCargoName + " was sold for a total of €" + revenue +
                    ". Due to the transport cost, the profit was €" + profit);

            updateData(-selectedAmount, selectedCargo, cargoPricePerTonne, transportCost);
            break;
        }
    }

    public void sendCargo() {

    }

    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }

    public String toString() {
        return "\nWarehouse: " + this.warehouseLocation + "\n" +
                "Current content: " + materials[0].getWeight() + "t Wood, " + materials[1].getWeight() + "t Iron and " + materials[2].getWeight() + "t LEGO.\n" +
                "Current available space: " + this.currentSpace + "\n" +
                "Max capacity: " + this.maxCapacity + "\n" +
                "Current budget: €" + Warehouse.budget;
    }

}