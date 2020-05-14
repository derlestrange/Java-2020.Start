package BankClients;

public abstract class Client {

    private static double bankAccount;

    Client(double bankAccount) {
        Client.bankAccount = bankAccount;
    }

    public abstract void info();

    public void putMoney(double money) {
        if (money < 0) {
            System.out.println("Некорректный ввод");
            System.out.println("Баланс: " + getBankAccount() + "\n");
            return;
        }
        System.out.println("Вы положили: " + money);
        setBankAccount(getBankAccount() + money);
        System.out.println("Баланс: " + getBankAccount() + "\n");
    }

    public void takeMoney(double money) {
        if (money < 0 || getBankAccount() < money || (money < 0 && getBankAccount() < money)) {
            System.out.println("Некорректный ввод");
            System.out.println("Баланс: " + getBankAccount() + "\n");
            return;
        }
        System.out.println("Вы сняли: " + money);
        setBankAccount(getBankAccount() - money);
        System.out.println("Баланс: " + getBankAccount() + "\n");
    }

    public double getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(double bankAccount) {
        Client.bankAccount = bankAccount;
    }
}
