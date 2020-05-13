package Accounts;

public class Account {

    private double bankAccount;

    public Account(double bankAccount) {
        System.out.println("Счет создан, баланс: " + bankAccount + "\n");
        this.bankAccount = bankAccount;
    }

    public void putMoney(double money) {
        if (money <= 0) {
            System.out.println("Некорректный запрос, попробуй снова");
        } else {
            bankAccount += money;
            System.out.println("Вы положили: " + money + " рублей.");
            System.out.println("Баланс: " + bankAccount + "\n");
        }
    }

    public void takeMoney(double money) {
        if (money <= 0 || money > bankAccount) {
            System.out.println("Некорректный запрос, попробуй снова");
        } else {
            bankAccount -= money;
            System.out.println("Вы сняли: " + money + " рублей.");
        }
    }

    public void setBankAccount(double bankAccount) {
        System.out.println("Устанавливаем баланс счета: " + bankAccount + "\n");
        this.bankAccount = bankAccount;
    }

    public double getBankAccount() {
        return bankAccount;
    }

}