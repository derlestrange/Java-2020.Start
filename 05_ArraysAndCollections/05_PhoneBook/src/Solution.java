import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {

        TreeMap<String, String> phoneBook = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи имя пользователя или его телефон:");

//        String name = "test";
//        String phoneNumber = "";

        while (true){

            String userInput = scanner.nextLine();
            String name = userInput.replaceAll()

            if (userInput.equalsIgnoreCase("list")){
                phoneBookList(phoneBook);
                continue;
            }

            if (phoneBook.containsKey(userInput)){
                phoneBook.get();
            }
            else {
                phoneBook.put(userInput, name);
            }
        }
    }
    private static void phoneBookList(Map<String, String>map){
        for (String key : map.keySet()){
            System.out.println("Ключ: " + key + " > " + map.get(key));
        }
    }
}
