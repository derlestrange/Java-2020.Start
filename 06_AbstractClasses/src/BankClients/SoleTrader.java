package BankClients;

//индивидуальный предприниматель
public class SoleTrader extends Client {

    public SoleTrader(double bankAccount) {
        super(bankAccount);
    }

    @Override
    public void putMoney(double money) {
        double commission;
        if (money < 0) {
            System.out.println("Некорректный ввод");
            System.out.println("Баланс: " + getBankAccount() + "\n");
            return;
        }

        if (money < 1000) {
            commission = (1 * money) / 100;
            System.out.println("Вы положили: " + money + "\nКоммисия: " + commission);
            setBankAccount(getBankAccount() + money);
            System.out.print("Баланс: ");
            System.out.println(getBankAccount() - commission + "\n");
        }

        if (money >= 1000) {
            commission = (0.5 * money) / 100;
            System.out.println("Вы положили: " + money + "\nКоммисия: " + commission);
            setBankAccount(getBankAccount() + money);
            System.out.print("Баланс: ");
            System.out.println(getBankAccount() - commission + "\n");
        }
    }

    @Override
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


}
