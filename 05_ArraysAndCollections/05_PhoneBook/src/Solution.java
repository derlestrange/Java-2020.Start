import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

    private static final TreeMap<String, String> phoneBook = new TreeMap<>();

    public static void main(String[] args) {

        System.out.println("Для вызова списка контактов введи команду \"list\" " +
                "\nДля завершения - \"end\"  ");

        for (; ; ) {

            String userInput = inputNameAndPhone();

            if (userInput.equalsIgnoreCase("list")) {
                printPhoneBook();
                continue;
            }

            if (userInput.equalsIgnoreCase("end")) {
                return;
            }

        }

    }

    private static String inputNameAndPhone() {

        Scanner scanner = new Scanner(System.in);

        for (; ; ) {

            String number = "";
            String name = "";

            System.out.print("Введи имя или номер телефона: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("list") || userInput.equalsIgnoreCase("end")) {
                return userInput;
            }

            if (userInput.matches("[0-9]+") &&
                    (userInput.length() >= 10 && userInput.length() <= 11)) {
                number = userInput;
            } else {
                if (userInput.isBlank()) {
                    continue;
                } else {
                    name = userInput;
                }
            }

            if (!phoneBook.containsKey(userInput) && number.equals(userInput)) {
                System.out.print("Введи имя: ");
                for (; ; ) {
                    String input = scanner.nextLine();
                    if (input.matches("[A-я\\s0-9]+")) {
                        phoneBook.put(userInput, input);
                        System.out.println("\nНовый пользователь!\nИмя: " + input + "\nНомер: " + userInput);
                        System.out.println();
                        break;
                    } else {
                        if (input.isBlank()) {
                            System.out.println("Введи имя, пожалуйста!");
                        }
                    }
                }
                continue;
            }

            if (!phoneBook.containsKey(userInput) && name.equals(userInput)) {
                System.out.print("Введи номер телефона: ");
                for (; ; ) {
                    String input = scanner.nextLine();
                    if (input.matches("[0-9]+") && (input.length() >= 10 && input.length() <= 11)) {
                        phoneBook.put(input, userInput);
                        System.out.println("\nНовый пользователь!\nИмя: " + userInput + "\nНомер: " + input);
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Ошибка! \nНомер телефона должен состоять из 10 или 11 цифр. " +
                                "\nПопробуй еще раз ввести номер: ");
                    }
                }
            }

            if (phoneBook.containsKey(userInput)) {
                System.out.println("\nТакой контакт уже есть:\n" +
                        "Имя: " + phoneBook.get(userInput) + "\nНомер: " + userInput);
                System.out.println();
            }

            return userInput;
        }

    }

    private static void printPhoneBook() {
        System.out.println();
        for (String key : ((Map<String, String>) Solution.phoneBook).keySet()) {
            System.out.println("Номер телефона: " + key + ", Имя: " + ((Map<String, String>) Solution.phoneBook).get(key));
        }
        System.out.println();
    }
}
