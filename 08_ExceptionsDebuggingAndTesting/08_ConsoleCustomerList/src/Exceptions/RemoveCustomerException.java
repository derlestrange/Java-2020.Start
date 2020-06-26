package Exceptions;

public class RemoveCustomerException extends RuntimeException{
    
    public RemoveCustomerException(){}

    public RemoveCustomerException(String s){
        super(s);
    }
}
