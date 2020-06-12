package Exceptions;

public class EmptyListCustomersException extends RuntimeException{
    public EmptyListCustomersException(){}

    public EmptyListCustomersException(String s){
        super(s);
    }
}
