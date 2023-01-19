package Application;
import java.util.Scanner;
import java.util.ArrayList;
import Application.cargo.*;


public class App {
    public static void main(String[] args){
        ArrayList<Warehouse> warehouseList = new ArrayList<>();     //Instantiation of arraylist in which all warehouses can be stored
        Scanner scan = new Scanner(System.in);                      //Instantiate scanner

        //Instantiation of several warehouses, to be added to warehouseList
        for(int i = 0; i < 3; i++){
            warehouseList.add(new Warehouse());
        }

        System.out.println("Select warehouse: ");
        while(true){
            String input = scan.nextLine();

            //check whether user gives a valid input. If so, continue after the loop. If not,
            if(input.equals("1") || input.equals("2") || input.equals("3")) {
                System.out.println("Warehouse selected");
                break;
            } else {
                System.out.println("Incorrect input, please select a warehouse by entering a valid option.");
                System.out.println("Select warehouse: ");
            }
        }


    }
}


class Warehouse{
	
	int capacity = 1000;
	Cargo cargo;
	int maxCapacity = 1000; // explanation no needed
	int currentCapacity;    // max capacity - cargo.amount its for calculation to tell if we have enough space of new cargo or not
	
	Cargo wood;
	Cargo iron;
	Cargo lego;
	
	
	public void fillWarehouse(int add) {
		// @@ "I have limit 1000 tons"
		// @@ "I want to choose what cargo is coming in: wood, iron, lego"
		// @@ "Add some amount of choosen cargo"
		// @@ "Check if i have enough space"
		// @@ "if no, change amount"             if capacity - cargo.amount < 0;
		// @@ "if yes, add the amount of cargo"  if capacity - cargo.amount >=0;
		// @@ "tell me how much capacity i have left"
		// @@ propably: capacity - wood.amount = space left;
		// @@            1000    -    wood.320 =    680;
		// @@            capacity = 680;
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
	
}