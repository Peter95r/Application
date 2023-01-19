package Application;
import java.net.StandardSocketOptions;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;

import Application.cargo.*;


public class App {
    public static void main(String[] args){
        ArrayList<Warehouse> warehouseList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String input = "";

        while(true){
            input = scan.nextLine();
            if(input.equals("1") || input.equals("2") || input.equals("3")) {
                System.out.println("Warehouse selected");
                break;
            } else {
                System.out.println("Incorrect input, please select a warehouse by entering the correct number.");
            }
        }
    }
}


class Warehouse{
	
	int capasity = 1000;
	Cargo cargo;
	
}