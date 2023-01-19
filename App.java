package Application;
import java.util.Scanner;
import java.util.ArrayList;
import Application.cargo.*;


public class App {
    public static void main(String[] args){
    	Warehouse ww = new Warehouse("abc");
    	ww.fillWarehouse();
    	ww.fillWarehouse();
    	ww.fillWarehouse();
    	ww.sellCargo();
    	ww.sellCargo();
    	ww.sellCargo();
    	System.out.println("OVER");
    	
    	
    	
        ArrayList<Warehouse> warehouseList = new ArrayList<>();     //Instantiation of arraylist in which all warehouses can be stored
        Warehouse selectedWarehouse;                                 //Declare variable to store currently selected warehouse

        //Instantiation of several warehouses, to be added to warehouseList
        warehouseList.add(new Warehouse("Deventer"));
        warehouseList.add(new Warehouse("Berlin"));
        warehouseList.add(new Warehouse("Warszawa"));

        //Call function to select a warehouse and store the chosen warehouse in variable
        while(true){
            selectedWarehouse = warehouseSelection(warehouseList);
            selectWarehouseOption(selectedWarehouse);
        }



    }

    public static void selectWarehouseOption(Warehouse selectedWarehouse){
        Scanner scan = new Scanner(System.in);                      //Instantiation of scanner
        outer: while(true){
            System.out.println(selectedWarehouse);

            System.out.println("\nWhat would you like to do in this warehouse?");
            System.out.println("1: Load cargo into warehouse");
            System.out.println("2: Move cargo from this warehouse to another");
            System.out.println("3: Sell cargo");
            System.out.println("4: Return to warehouse selection");
            System.out.print("Please select an option: ");

            String input = scan.nextLine();

            try {
                if(Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 4){
                    switch(input){
                        case "1":
                            selectedWarehouse.fillWarehouse();
                            break;
                        case "2":
                            selectedWarehouse.sendCargo();
                            break;
                        case "3":
                            selectedWarehouse.sellCargo();
                            break;
                        case "4":
                            break outer;
                    }
                } else {
                    throw new InvalidSelectionException();
                }
            } catch (Exception e){
                System.out.println("\nIncorrect input, please select a valid option.");
            }
        }
    }

    //Created a static method for warehouse selection
    public static Warehouse warehouseSelection(ArrayList<Warehouse> warehouseList){
        Scanner scan = new Scanner(System.in);                      //Instantiation of scanner

        while(true){
            System.out.println("\nList of warehouses: ");

            //Print an option and the name (city) for each warehouse
            for(Warehouse warehouse: warehouseList){
                System.out.println((warehouseList.indexOf(warehouse) + 1) + ": " + warehouse.getName());
            }

            System.out.print("Select warehouse: ");         //...

            String input = scan.nextLine();                 //Ask for user input

            //Check whether user gives a valid option (between 1 and warehouseList.size() as input. If so, return the Warehouse object corresponding to
            //that option. If not, retry.
            try {
                return warehouseList.get(Integer.parseInt(input)-1);
            } catch(Exception e) {
                System.out.println("\nIncorrect input, please select a valid option.");
            }
        }
    }
}