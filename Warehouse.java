package Application;
import java.util.Scanner;

import Application.cargo.*;

class Warehouse{

    private String name;
    private int currentContent = 500;
    private final int maxCapacity = 1000; // i made it final for now. its easier to work with 
    private int currentSpace;    // max capacity - cargo.amount its for calculation to tell if we have enough space of new cargo or not

    private Cargo[] materials = {new Wood(), new Iron(), new Lego()};

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
    private void updateData(int addedAmount, Cargo target) {
    	
    	// first check if i can add new amount
    	if(this.currentSpace - addedAmount >= 0) {
    		
    		// update amount in target (in cargo this is called weight)
    		target.addWeight(addedAmount);
    		System.out.println(target.getClass() + ": current weight is: " + target.getWeight() +" //test message from: Warehouse.udateData()");
    		// update free space based on new data
    		initSpace();
    	}
    	else {
    		// for now this part does nothing, only tell you that is not enough space
    		System.out.println("Not enough space in warehouse.");
    		System.out.println("You have only space for: " + this.currentSpace + " tones in this warehouse.");
    	}
    }
    
    
    
    // this method will fill your warehouse
    public void fillWarehouse() {
    	Scanner in = new Scanner(System.in); // local scanner
    	Cargo target;                       // cargo on which we will operate
    	
    	
        // @@ "I want to choose what cargo is coming in: wood, iron, lego"
    	System.out.println("What material do you want to get ?");
    	System.out.println("Wood: 1, Iron: 2, Lego: 3");
    	
    	// for now this part dont do anything if, input is wrong like wrong number or letter, this will come latter
    	// popably will be: instead in.nextInt() will be Integer.parseInt(in.next()) and check if int is not to big
    	target = materials[in.nextInt()-1]; 
    	
        // @@ "Add some amount of chosen cargo"
    	System.out.println("How much material do you want to get?");
    	int amount = in.nextInt();
    	
        // @@ "Check if i have enough space for this cargo"
    	// this method already check if can make changes. If can, will update it.
    	updateData(amount, target);
                                                        
    }

    
    
    
    public void sellCargo() {
        // @@ "choose which cargo has to go"
        // @@ "tell me how much we are goint to sell"
        // @@ "i will check if we have this amount"
        // @@ "if not: you can call method fillWarehouse or change amount of this cargo "
        // @@ "choose transport"
        // @@ "i will check if transport can carry this cargo"
        // @@ "if not: back to change amount step or change transport"
        // @@ "if everything is all right: send cargo and display message"
        // @@ "update the data: for example wood.amount - sended amount = updated wood.amount
        // @@ updated currentCapacity = capacity - updated wood.amount"
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
                "Current contents: " + this.currentContent + "\n" +
                "Max capacity: " + this.maxCapacity;
    }

}