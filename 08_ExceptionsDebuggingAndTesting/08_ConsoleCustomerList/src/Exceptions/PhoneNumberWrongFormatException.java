package Exceptions;

public class PhoneNumberWrongFormatException extends RuntimeException {

    public PhoneNumberWrongFormatException(){ }

    public PhoneNumberWrongFormatException(String s){
        super(s);
    }
}
