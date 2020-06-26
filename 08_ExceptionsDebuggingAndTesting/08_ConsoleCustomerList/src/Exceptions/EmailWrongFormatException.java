package Exceptions;

public class EmailWrongFormatException extends RuntimeException {

    public EmailWrongFormatException(){ }

    public EmailWrongFormatException(String s){
        super(s);
    }
}
