import org.apache.commons.validator.routines.EmailValidator;

import java.util.HashMap;

public class CustomerStorage {
    private HashMap<String, Customer> storage;
    private EmailValidator emailValidator = EmailValidator.getInstance();

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws Exception {
        String[] components = data.split("\\s+");

        if (components.length != 4) {
            throw new ArrayIndexOutOfBoundsException("\nНеверный формат ввода. \nПравильный формат: " +
                    "add Василий Петров vasily.petrov@gmail.com +79215637722\n");
        }
        if (emailValidator.isValid(components[2]) && components[3].matches("\\+[0-9]{10,11}")) {
            String name = components[0] + " " + components[1];
            storage.put(name, new Customer(name, components[3], components[2]));
        } else {
            throw new Exception("Почта или номер введены неверно. \nПравильный формат: " +
                    "vasily.petrov@gmail.com +79215637722");
        }
    }

    public void listCustomers() throws Exception {
        if (storage.size() == 0) {
            throw new Exception("Список клиентов пуст!");
        } else {
            storage.values().forEach(System.out::println);
        }
    }

    public void removeCustomer(String name) {
        if (!storage.containsKey(name)) {
            throw new ArrayIndexOutOfBoundsException("\nТакого клиента не существует! Попробуй снова\n");
        }
        storage.remove(name);
    }

    public int getCount() {
        return storage.size();
    }
}