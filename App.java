package Application;
import java.util.Scanner;
import java.util.ArrayList;
import Application.cargo.*;


public class App {
    public static void main(String[] args){
        ArrayList<Warehouse> warehouseList = new ArrayList<>();     //Instantiation of arraylist in which all warehouses can be stored
        Scanner scan = new Scanner(System.in);                      //Instantiation of scanner
        Warehouse currentWarehouse;                                 //Declare variable to store currently selected warehouse

        //Instantiation of several warehouses, to be added to warehouseList
        warehouseList.add(new Warehouse("Deventer"));
        warehouseList.add(new Warehouse("Berlin"));
        warehouseList.add(new Warehouse("Warszawa"));

        currentWarehouse = warehouseSelection(warehouseList, scan);
        System.out.println(currentWarehouse);

        currentWarehouse.selectOption();
    }

    public void selectOption(){


        while(true){
            System.out.println("What would you like to do in this warehouse?");
            System.out.println("1: Load cargo into warehouse");
            System.out.println("2: Move cargo from this warehouse to another");
            System.out.println("3: Return to warehouse selection");
            System.out.print("Please select an option: ");

            try {

            } catch (Exception e) {
                System.out.println("Incorrect input, please select a warehouse by entering a valid option.\n");
            }
        }
    }



    //Created a static method for warehouse selection
    public static Warehouse warehouseSelection(ArrayList<Warehouse> warehouseList, Scanner scan){
        while(true){
            System.out.println("List of warehouses: ");

            //Print an option and the name (city) for each warehouse
            for(Warehouse warehouse: warehouseList){
                System.out.println((warehouseList.indexOf(warehouse) + 1) + ": " + warehouse.getName());
            }

            System.out.print("Select warehouse: ");         //...

            String input = scan.nextLine();                 //Ask for user input

            //Check whether user gives a valid option as input. If so, return the Warehouse object corresponding to
            //that option. If not, retry.
            try {
                return warehouseList.get(Integer.parseInt(input)-1);
            } catch(Exception e) {
                System.out.println("Incorrect input, please select a warehouse by entering a valid option.\n");
            }
        }
    }
}