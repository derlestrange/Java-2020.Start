import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    private static final ArrayList<String> toDoList = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Введи команду. Для вызова списка комманд введи \"HELP\"");
        while (true) {

            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine() + " ";

            String commandUser = userInput.substring(0, userInput.indexOf(" ")).toUpperCase().trim();
            String numberAndCause = userInput.substring(commandUser.length()).trim();
            String cause = numberAndCause.replaceAll("^[\\d]*", "").trim();
            String number = numberAndCause.replaceAll("[A-z]|[\\W]+[\\W\\d]+", "").trim();

            switch (commandUser) {
                case "HELP":
                    Help();
                    break;
                case "ADD":
                    if (number.equals("")) {
                        toDoList.add(cause);
                    }
                    else if (Integer.parseInt(number) > toDoList.size()) {
                        toDoList.add(cause);
                    }
                    else {
                        toDoList.add(Integer.parseInt(number), cause);
                    }
                    FullList();
                    break;
                case "DELETE":
                    toDoList.remove(Integer.parseInt(number));
                    FullList();
                    break;
                case "EDIT":
                    if (toDoList.size()==0){
                        System.out.println("Список пуст.\nДобавь что-нибудь в список через команду ADD");
                    } else {
                        toDoList.set(Integer.parseInt(number), cause);
                    }
                    FullList();
                    break;
                case "LIST":
                    FullList();
                    break;
                case "END":
                    return;
                default:
                    System.out.println("Ошибка!\nВведи команду правильно, справка: HELP");
            }
        }
    }

    private static void FullList() {
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println("№ " + i + ". " + toDoList.get(i));
        }
    }

    private static void Help(){
        System.out.println("LIST - команда, выводящая список дел" +
                "\nADD - команда, добавляющая новое дело" +
                "\nEDIT - команда, позволяющая редактировать дело" +
                "\nDELETE - команда, удаляющая дело" +
                "\nEND - команда, завершающая выполнение программы");
    }
}