import java.util.Arrays;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {

        for (; ; ) {
            System.out.print("Введи свой сотовый телефон: ");
            Scanner scanner = new Scanner(System.in);
            String phoneNumber = scanner.nextLine();

            String phone = phoneNumber.replaceAll("[^0-9]+", "");

            if (phone.length() >= 10 && phone.length() <= 11) {

                System.out.println("+" + phone.replaceFirst("[8]", "7"));
                break;
            } else {
                System.out.println("Неверный формат ввода, попробуй еще раз: ");
            }
        }
    }
}
