import Exceptions.*;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.HashMap;

public class CustomerStorage {
    private HashMap<String, Customer> storage;
    private EmailValidator emailValidator = EmailValidator.getInstance();

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        String[] components = data.split("\\s+");

        if (components.length != 4) {
            throw new AddingCustomerException("Wrong input format! \nCorrectly format: " +
                    "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if (emailValidator.isValid(components[2]) && components[3].matches("\\+[0-9]{10,11}")) {
            String name = components[0] + " " + components[1];
            storage.put(name, new Customer(name, components[3], components[2]));
        }
        if (!emailValidator.isValid(components[2])) {
            throw new EmailWrongFormatException("Wrong format email! \nCorrectly format: vasily.petrov@gmail.com");
        }
        if (!components[3].matches("\\+[0-9]{10,11}")) {
            throw new PhoneNumberWrongFormatException("Incorrect phone number format! \nCorrectly format: +79215637722");
        }
    }

    public void listCustomers() {
        if (getCount() == 0) {
            throw new EmptyListCustomersException("List is empty! ");
        } else {
            storage.values().forEach(System.out::println);
        }
    }

    public void removeCustomer(String name) {
        if (!storage.containsKey(name)) {
            throw new RemoveCustomerException("Wrong remove format! ");
        }
        storage.remove(name);
    }

    public int getCount() {
        return storage.size();
    }
}