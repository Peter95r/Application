package Application;

public class InvalidSelectionException extends Exception {

    public InvalidSelectionException(){
        super("Incorrect input, please enter a valid option.");
    }
}
