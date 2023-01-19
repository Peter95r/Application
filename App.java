package Application;
import java.util.Scanner;
import java.util.ArrayList;
import Application.cargo.*;


public class App {
    public static void main(String[] args){
        ArrayList<Warehouse> warehouseList = new ArrayList<>();     //Instantiation of arraylist in which all warehouses can be stored
        Scanner scan = new Scanner(System.in);                      //Instantiate scanner

        //Instantiation of several warehouses, to be added to warehouseList
        warehouseList.add(new Warehouse("Deventer"));
        warehouseList.add(new Warehouse("Berlin"));
        warehouseList.add(new Warehouse("Warszawa"));

        //Declaration of currently selected warehouse
        Warehouse currentWarehouse;

        System.out.println("Select warehouse: ");

        //Print an option and the name (city) for each warehouse
        for(Warehouse warehouse: warehouseList){
            System.out.println((warehouseList.indexOf(warehouse) + 1) + ": " + warehouse.getName());
        }

        while(true){
            int chosenIndex = 0;
            String input = scan.nextLine();

            //check whether user gives an Integer input. If so, store in chosenIndex.
            try {
                chosenIndex = Integer.valueOf(input) - 1;
            } catch(Exception e){
                //possible error message here, although it is already offered in the next if-block as well. Probably unnecessary
            }

            if(chosenIndex >= 1 && chosenIndex <= warehouseList.size())  {
                currentWarehouse = warehouseList.get(chosenIndex);
                System.out.println(currentWarehouse);
                break;
            } else {
                System.out.println("Incorrect input, please select a warehouse by entering a valid option.");
                System.out.println("Select warehouse: ");
            }
        }
    }
}