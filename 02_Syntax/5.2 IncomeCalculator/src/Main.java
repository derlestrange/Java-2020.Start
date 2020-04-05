import java.util.Scanner; //импорт библиотеки, которая поможет нам в вычислениях

public class Main {
    private static int minIncome = 200000; //порог вхождения по доходам
    private static int maxIncome = 900000; //максимальная сумма по доходам в рамках этой программы

    private static int officeRentCharge = 140000; //плата за аренду
    private static int telephonyCharge = 12000; //плата за телефонию
    private static int internetAccessCharge = 7200; //плата за интернет

    private static int assistantSalary = 45000; //зарплата помощника
    private static int financeManagerSalary = 90000; //зарплата финансового менеджера

    private static double mainTaxPercent = 0.24; //процент основого налога от дохода компании
    private static double managerPercent = 0.15; //проценты менеджера от дохода компании

    private static double minInvestmentsAmount = 100000; //минимальная сумма инвестиций

    public static void main(String[] args) {
        //задание со звездочкой

        double minIncome = (minInvestmentsAmount / (1 - mainTaxPercent) + calculateFixedCharges())
                / (1 - managerPercent);
        System.out.println(minIncome);

        while (true) //цикл, который будет выполняться сколько мы захотим, или пока не сломается программа
        {
            System.out.println("Введите сумму доходов компании за месяц " +
                    "(от 200 до 900 тысяч рублей): "); //печатаем текст в консоль
            int income = (new Scanner(System.in)).nextInt(); //переменная "доход", которая берет введеные данные пользователем

            if (!checkIncomeRange(income)) { //метод проверки введенного числа
                continue; //если все ок, то идем дальше
            }

            double managerSalary = income * managerPercent; //считаем зарплату менеджера
            double pureIncome = income - managerSalary -
                    calculateFixedCharges(); //метод, который считает доход без учета вычет ЗП работников
            double taxAmount = mainTaxPercent * pureIncome; //считаем налог
            double pureIncomeAfterTax = pureIncome - taxAmount; //чистый доход после налогов

            boolean canMakeInvestments = pureIncomeAfterTax >=
                    minInvestmentsAmount; //проверяем, можем ли инвестировать после налогов

            System.out.println("Зарплата менеджера: " + managerSalary); //печатаем в консоль ЗП менеджера
            System.out.println("Общая сумма налогов: " +
                    (taxAmount > 0 ? taxAmount : 0)); //печатаем в консоль сумму налогов
            System.out.println("Компания может инвестировать: " +
                    (canMakeInvestments ? "да" : "нет")); //проверяем, можем ли инвистировать
            if (pureIncome < 0) {
                System.out.println("Бюджет в минусе! Нужно срочно зарабатывать!"); //проверка на возможность инвестиций
            }
        }
    }

    private static boolean checkIncomeRange(int income) //создаем метод. проверяем число, введенное в консоль
    {
        if (income < minIncome) {
            System.out.println("Доход меньше нижней границы");
            return false;
        }
        if (income > maxIncome) {
            System.out.println("Доход выше верхней границы");
            return false;
        }
        return true; //если числое ни выше, ни ниже, то продолжаем цикл
    }

    private static int calculateFixedCharges() //метод, который считает фиксированные доходы
    {
        return officeRentCharge +
                telephonyCharge +
                internetAccessCharge +
                assistantSalary +
                financeManagerSalary;
    }
}
