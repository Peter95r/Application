package Application;
import Application.cargo.*;


public class App {
    public static void main(String[] args){

    	UI ui = new UI();

        //Instantiation of several warehouses, to be added to warehouseList
        ui.addWarehouse("Deventer");
        ui.addWarehouse("Berlin");
        ui.addWarehouse("Warszawa");
        ui.addWarehouse("Rotterdam");

        ui.start();
    }
}