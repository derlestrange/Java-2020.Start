import java.util.*;

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

            System.out.print("Введи имя или номер телефона: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("list") || userInput.equalsIgnoreCase("end")) {
                return userInput;
            }

            if (userInput.matches("[0-9]+") && (userInput.length() >= 10 && userInput.length() <= 11)) {
                if (!phoneBook.containsKey(userInput)) {
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

                if (phoneBook.containsKey(userInput)) {
                    System.out.println("\nТакой контакт уже есть:\n" +
                            "Имя: " + phoneBook.get(userInput) + "\nНомер: " + userInput);
                    System.out.println();
                }

            } else {
                if (phoneBook.containsValue(userInput)) {
                    for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                        System.out.println("\nТакой контакт уже есть:\n" +
                                "Имя: " + entry.getValue() + "\nНомер: " + entry.getKey() + "\n");

                    }
                    System.out.println("Добавить еще одного человека с таким именем?\nДа или Нет");
                    String repeatName = scanner.nextLine();
                    if (repeatName.equalsIgnoreCase("нет")) {
                        continue;
                    }
                }

                if (userInput.isBlank()) {
                    continue;
                }

                if (!phoneBook.containsKey(userInput)) {
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
            }
            return userInput;
        }

    }

    private static void printPhoneBook() {
        TreeSet<String> sortedTest = new TreeSet<>();

        for (String s : phoneBook.keySet()) {
            sortedTest.add("Имя: " + phoneBook.get(s) + ", Телефон: " + s);
        }

        for (String s : sortedTest) {
            System.out.println(s);
        }
        System.out.println();
    }
}
