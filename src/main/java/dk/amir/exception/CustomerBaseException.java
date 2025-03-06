package dk.amir.exception;

public class CustomerBaseException extends Exception{
    public CustomerBaseException(String message) {
        super(message);
    }
    public CustomerBaseException(){
        super();
    }
}
