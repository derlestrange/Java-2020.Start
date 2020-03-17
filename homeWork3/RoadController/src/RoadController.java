import core.*;
import core.Camera;

import java.util.Scanner;

public class RoadController {
    private static double passengerCarMaxWeight = 3500.0; // kg //создание переменной
    private static int passengerCarMaxHeight = 2000; // mm //создание переменной
    private static int controllerMaxHeight = 3500; // mm //создание переменной

    private static int passengerCarPrice = 100; // RUB //создание переменной
    private static int cargoCarPrice = 250; // RUB //создание переменной
    private static int vehicleAdditionalPrice = 200; // RUB //создание переменной

    public static void main(String[] args) {
        System.out.println("Сколько автомобилей сгенерировать?");

        Scanner scanner = new Scanner(System.in); //создание переменной
        int carsCount = scanner.nextInt(); //создание переменной

        for (int i = 0; i < carsCount; i++) //создание переменной
        {
            Car car = Camera.getNextCar(); //создание переменной
            System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            if (car.isSpecial) {
                openWay();
                continue;
            }

            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            int price = calculatePrice(car); //создание переменной
            if (price == -1) {
                continue;
            }

            if(car.hasVehicle){
                System.out.println("У Вас имеется прицеп.");
            }

            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(Car car) {
        int carHeight = car.height; //создание переменной
        int price = 0; //создание переменной
        if (carHeight > controllerMaxHeight) {
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            return -1;
        } else if (carHeight > passengerCarMaxHeight) {
            double weight = car.weight; //создание переменной
            
            if (weight > passengerCarMaxWeight) {
                price = cargoCarPrice; //создание переменной
            } else {
                price = passengerCarPrice; //создание переменной
            }
        } else {
            price = cargoCarPrice;
        }
        if (car.hasVehicle) {
            price = price + vehicleAdditionalPrice;
        }
        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay() {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    private static void blockWay(String reason) {
        System.out.println("Проезд невозможен: " + reason);
    }
}