package Application;

import Application.cargo.Cargo;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private final ArrayList<Warehouse> warehouseList = new ArrayList();     //Instantiation of ArrayList of available warehouses
    private Warehouse selectedWarehouse;                                    //Declare variable to store currently selected warehouse
    private Scanner scan = new Scanner(System.in);                          //Instantiate scanner

    //Method to add warehouse to warehouseList
    public void addWarehouse(String name) {
        this.warehouseList.add(new Warehouse(name));
    }

    //Method to start the UI (the program flow)
    public void start() {
        while (true) {
            this.selectedWarehouse = this.selectWarehouse(warehouseList);
            this.selectWarehouseOption(this.selectedWarehouse);
        }
    }

    //method to select warehouse from list of warehouses
    public Warehouse selectWarehouse(ArrayList<Warehouse> warehouseList) {
        Scanner scan = new Scanner(System.in);                      //Instantiation of scanner

        while (true) {
            System.out.println("\nList of warehouses: ");                       //...

            //Print an option and the name (city) for each warehouse
            for (Warehouse warehouse : warehouseList) {
                System.out.println((warehouseList.indexOf(warehouse) + 1) + ": " + warehouse.getName());
            }

            System.out.print("Please select a warehouse (q to quit): ");        //...

            String input = scan.nextLine();                                     //Ask for user input

            //if input is q, quit program
            if (input.equals("q") || input.equals("Q")) {
                System.exit(0);
            }

            //Check whether user gives a valid option (between 1 and warehouseList.size() as input. If so, return the Warehouse object corresponding to
            //that option. If not, retry.
            try {
                return warehouseList.get(Integer.parseInt(input) - 1);
            } catch (Exception e) {
                System.out.println("\nIncorrect input, please select a valid option.");
            }
        }
    }

    public void selectWarehouseOption(Warehouse selectedWarehouse) {
        outer: while (true) {
            System.out.println(selectedWarehouse);

            System.out.println("\nWhat would you like to do in this warehouse?");
            System.out.println("1: Load cargo into warehouse");
            System.out.println("2: Move cargo from this warehouse to another");
            System.out.println("3: Sell cargo");
            System.out.println("4: Return to warehouse selection");
            System.out.print("Please select an option: ");

            String input = scan.nextLine();

            try {
                if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 4) {
                    switch (input) {
                        case "1":
                            selectedWarehouse.fillWarehouse(this);
                            break;
                        case "2":
                            selectedWarehouse.sendCargo();
                            break;
                        case "3":
                            selectedWarehouse.sellCargo(this);
                            break;
                        case "4":
                            break outer;
                    }
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Incorrect input, please select a valid option.");
            }
        }
    }

    public Cargo selectCargo() {
        // choose what cargo is coming in: wood, iron, lego
        while(true) {
            System.out.println("\nWhat type of cargo would you like to select?");
            System.out.println("1: Wood");
            System.out.println("2: Iron");
            System.out.println("3: LEGO");
            System.out.print("Please select an option: ");
            String input = scan.nextLine();
            try {
                if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 3) {
                    return selectedWarehouse.getMaterials()[Integer.parseInt(input) - 1];
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("\nIncorrect input, please select a valid option.");
            }
        }
    }

    public int selectAmount(){
        while (true) {
            System.out.println("\nHow many tonnes?");
            System.out.print("Enter amount: ");
            String amount = scan.nextLine();

            try {
                return Integer.parseInt(amount);
            } catch (Exception e){
                System.out.println("\nIncorrect input, please select a valid option.");
            }
        }
    }
}

