import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        //вывести фамилию имя и отчество

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введи ФИО: ");
        String fullName = scanner.nextLine();
        
        String surName = fullName.substring(0, fullName.indexOf(' ')).trim();
        System.out.println("Фамилия: " + surName);

        String name = fullName.substring(fullName.indexOf(' '), fullName.lastIndexOf(' ')).trim();
        System.out.println("Имя: " + name);

        String patronymic = fullName.substring(fullName.lastIndexOf(' ')).trim();
        System.out.println("Отчество: " + patronymic);
    }
}
