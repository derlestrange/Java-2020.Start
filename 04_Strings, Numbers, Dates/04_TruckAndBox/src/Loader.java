import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {

        //В каждый грузовик влезает максимум 12 контейнеров. В каждый контейнер - не более 27 ящиков.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введи число ящиков: ");
        int count = scanner.nextInt();
        int truckNum = 1, boxNum = 1, containerNum = 1, truckCount = 12, containerCount = 27;
        for (int i = 0; i < count; i++) {
            if (boxNum % (truckCount * containerCount) == 1) {
                System.out.println("Грузовик " + truckNum++);
            }

            if (boxNum % containerCount == 1) {
                System.out.println("\tКонтейнер " + containerNum++);
            }
            System.out.println("\t\tЯщик " + boxNum++);
        }
        System.out.println("Итого:\nГрузовиков: " + (truckNum - 1));
        System.out.println("Контейнеров: " + (containerNum - 1));
        System.out.println("Ящиков: " + (count));
    }
}
