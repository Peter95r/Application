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
	
}