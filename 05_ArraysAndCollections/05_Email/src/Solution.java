import org.apache.commons.validator.routines.EmailValidator;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    
    private static final HashSet<String> eMails = new HashSet<>();
    private static int number = 0;

    public static void main(String[] args) {

        System.out.print("Введи электронную почту: ");
        Scanner scanner = new Scanner(System.in);

        for (; ; ) {

            String userInput = scanner.nextLine();

            int commandFinish = userInput.compareToIgnoreCase("end");
            int commandList = userInput.compareToIgnoreCase("list");

            EmailValidator correctlyEmail = EmailValidator.getInstance();

            if (correctlyEmail.isValid(userInput)) {
                eMails.add(userInput);
            } else if (commandFinish == 0) {
                return;
            } else if (commandList == 0) {
                List();
            } else {
                System.out.println("Электронная почта введена не корректно, попробуй снова:");
            }

//            boolean correctlyEmail = userInput.matches("(\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6})");
//
//            if (correctlyEmail) {
//                eMails.add(userInput);
//            } else if (commandFinish == 0) {
//                return;
//            } else if (commandList == 0) {
//                List();
//            } else {
//                System.out.println("Электронная почта введена не корректно, попробуй снова:");
//            }
        }

    }

    private static void List() {
        for (String s : eMails) {
            System.out.println("№ " + number++ + ". " + s);
        }
    }

}

