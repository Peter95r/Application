package Application;
import java.util.Scanner;
import Application.vehicles.*;

import Application.cargo.*;
import Application.vehicles.Transport;

class Warehouse{

    private String name;
    private final int maxCapacity = 1000; // i made it final for now. its easier to work with 
    private int currentSpace;   



    private Transport[] transport = {new Truck(), new Ship(), new Airplane()};
    private Cargo[] materials = {new Wood(), new Iron(), new Lego()};
    private static final double budget = 100_000.0; // static because there is one budget to manage 3 warehouses. for start 100k, but we can change
    


    //constructor with name as parameter
    public Warehouse(String name){
        this.name = name;
        this.currentSpace = this.maxCapacity; // by default created warehouse is empty so current space = maxCap
    }

    
    // set current space based on data
    // this method is private, only this class can use it for own calculation
    private void initSpace() {
    	this.currentSpace = this.maxCapacity - materials[0].getWeight()-materials[1].getWeight()-materials[2].getWeight();
    	System.out.println("Current free space is: "+this.currentSpace + " //test message from: Warehouse.initSpace()");
    }
   
    
    
    // this method will take target(one of those 3 type of cargo)
    // and add new amount to this target
    // after that will update our free space in warehouse, based of new data(new amount of cargo)
    // this method is private, only this class can use it for own calculation
    // @@ has to also update budget @@
    private void updateData(int addedAmount, Cargo target) {
    	
    	double tempValue = 0; 
    	if(target.getClass().getSimpleName().equals("Wood")) tempValue = Wood.sellValue;
    	else if(target.getClass().getSimpleName().equals("Iron")) tempValue = Iron.sellValue;
    	else if(target.getClass().getSimpleName().equals("Lego")) tempValue = Lego.sellValue;
    	
    	System.out.println(tempValue);
    	
    	// first check if i can add new amount
    	if(this.currentSpace - addedAmount >= 0 && Warehouse.budget - (addedAmount * tempValue)>=0) {
    		
    		// update amount in target (in cargo this is called weight)
    		target.addWeight(addedAmount);
    		System.out.println(target.getClass() + ": current weight is: " + target.getWeight() +" //test message from: Warehouse.updateData()");
    		// update free space based on new data
    		initSpace();
    	}
    	else {
    		// for now this part does nothing, only tell you that is not enough space
    		System.out.println("Not enough space or money in warehouse.");
    		System.out.println("You have only space for: " + this.currentSpace + " tones in this warehouse.");
    	}
    }

    public Cargo[] getMaterials() {
        return materials;
    }

    // @@ we have to update this method, it has take away the money from budget. maybe new method for budget @@
    // this method will fill your warehouse
    public void fillWarehouse(UI ui) {
    	Cargo selectedCargo = ui.selectCargo();
        int selectedAmount = ui.selectAmount();

        updateData(selectedAmount, selectedCargo);

    }

        
    public void sellCargo(UI ui) {
    	
        // choose which cargo has to go
    	Scanner scan = new Scanner(System.in);  
    	
    	Cargo selectedCargo = ui.selectCargo();
    	int selectedAmount = -ui.selectAmount();

    	System.out.println(selectedCargo.getClass() + " :" + selectedCargo.getWeight() + " //test message from: Warehouse.sellCargo()");
    	
    	updateData(selectedAmount,selectedCargo); // this is only for test, must be deleted later
    	
    	
        // check if we have this amount"
    	if(selectedCargo.getWeight() >= selectedAmount) {
    		// @@ chose transport
    		// @@ "i will check if transport can carry this cargo"
    		// @@ "if not: back to change amount step or change transport"
    	}
    	// @@ "if not: you can call method fillWarehouse or change amount of this cargo "
    	else {
    		// @@ refill or change transport
    	}
        
        // @@ "if everything is all right: send cargo and display message"
    	// @@ and call method updateData();

    }

    public void sendCargo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "\nWarehouse: " + this.name + "\n" +
                "Current content: " + materials[0].getWeight() + "t Wood, " + materials[1].getWeight() + "t Iron and " + materials[2].getWeight() + "t LEGO.\n" +
                "Current available space: " + this.currentSpace + "\n" +
                "Max capacity: " + this.maxCapacity;
    }

}