import Exceptions.AddingCustomerException;
import Exceptions.EmptyListCustomersException;
import Exceptions.RemoveCustomerException;

import java.util.Scanner;

public class Main {
    private static String addCommand = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static String commandExamples = "\t" + addCommand + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static String commandError = "Wrong command! Available command examples: \n" +
            commandExamples;
    private static String helpText = "Command examples:\n" + commandExamples;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();
        for (; ; ) {

            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);
            try {
                if (tokens[0].equals("add")) {
                    executor.addCustomer(tokens[1]);
                }
            } catch (AddingCustomerException e) {
                e.getMessage();
            }

            try {
                if (tokens[0].equals("list")) {
                    executor.listCustomers();
                }
            } catch (EmptyListCustomersException e) {
                e.getMessage();
            }

            try {
                if (tokens[0].equals("remove")) {
                    executor.removeCustomer(tokens[1]);
                }
            } catch (RemoveCustomerException e) {
                e.getMessage();
            }

//            if (tokens[0].equals("count")) {
//                System.out.println("There are " + executor.getCount() + " customers");
//            } else if (tokens[0].equals("help")) {
//                System.out.println(helpText);
//            } else {
//                System.out.println(commandError);
//            }

        }
    }
}
