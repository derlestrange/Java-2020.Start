import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {

    private static boolean checkName(String string) {
        Pattern pattern = Pattern.compile("([А-Я][а-я]+-?)?([А-Я][а-я]+\\s[А-Я][а-я]+\\s[А-Я][а-я]+)");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static void main(String[] args) {
        //вывести фамилию имя и отчество

        for (; ; ) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введи ФИО: ");
            String fullName = scanner.nextLine();

            if (checkName(fullName)) {

                String[] fullNameReg = fullName.split(" ");
                String[] fullNameList = {"Фамилия:  ", "Имя:\t  ", "Отчество: "};

                for (int i = 0; i < fullNameReg.length; i++) {
                    System.out.println(fullNameList[i] + fullNameReg[i]);
                }

                break;

            } else {
                System.out.println("Неверный формат ввода, попробуй снова");
            }

        }
    }
}