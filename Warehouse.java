package Application;
import Application.cargo.Cargo;

class Warehouse{

    private String name;
    private int currentContent = 500;
    private Cargo cargo;
    private int maxCapacity = 1000; // explanation no needed
    private int currentCapacity;    // max capacity - cargo.amount its for calculation to tell if we have enough space of new cargo or not

    Cargo wood;
    Cargo iron;
    Cargo lego;

    //constructor with name as parameter
    public Warehouse(String name){
        this.name = name;
    }

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