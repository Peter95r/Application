package Application;
import java.util.Scanner;
import java.util.ArrayList;
import Application.cargo.*;


public class App {
    public static void main(String[] args){
    	
    	// This is only for fill methodTest: run it so you know how it looks 
    	Warehouse ww = new Warehouse("TestHouse");
    	ww.fillWarehouse();
    	ww.fillWarehouse();
    	ww.fillWarehouse();
    	
        ArrayList<Warehouse> warehouseList = new ArrayList<>();     //Instantiation of arraylist in which all warehouses can be stored
        Scanner scan = new Scanner(System.in);                      //Instantiate scanner
        Warehouse currentWarehouse;                                 //Declare variable to store currently selected warehouse

        //Instantiation of several warehouses, to be added to warehouseList
        warehouseList.add(new Warehouse("Deventer"));
        warehouseList.add(new Warehouse("Berlin"));
        warehouseList.add(new Warehouse("Warszawa"));

        currentWarehouse = warehouseSelection(warehouseList, scan);
        System.out.println(currentWarehouse);


    }





    //Created a static method for warehouse selection
    public static Warehouse warehouseSelection(ArrayList<Warehouse> warehouseList, Scanner scan){
        while(true){
            int chosenIndex = 0;

            System.out.println("List of warehouses: ");
            //Print an option and the name (city) for each warehouse
            for(Warehouse warehouse: warehouseList){
                System.out.println((warehouseList.indexOf(warehouse) + 1) + ": " + warehouse.getName());
            }

            System.out.print("Select warehouse: ");
            //Ask for user input
            String input = scan.nextLine();

            //check whether user gives an Integer input. If so, store in chosenIndex.
            try {
                chosenIndex = Integer.valueOf(input) - 1;
            } catch(Exception e){
                //possible error message here, although it is already offered in the next if-block as well. Probably unnecessary
            }

            if(chosenIndex >= 1 && chosenIndex <= warehouseList.size())  {
                return warehouseList.get(chosenIndex);

            } else {
                System.out.println("Incorrect input, please select a warehouse by entering a valid option.");
            }
        }
    }
}