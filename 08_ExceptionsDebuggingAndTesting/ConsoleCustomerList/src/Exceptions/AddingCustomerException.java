package Exceptions;

public class AddingCustomerException extends RuntimeException{

    public AddingCustomerException(){}

    public AddingCustomerException(String s){
        super(s);
    }
}
