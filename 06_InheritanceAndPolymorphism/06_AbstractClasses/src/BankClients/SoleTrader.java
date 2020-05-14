package BankClients;

import java.time.LocalDate;

//индивидуальный предприниматель
public class SoleTrader extends Client {

    private static final LocalDate createTime = LocalDate.now();

    public SoleTrader(double bankAccount) {
        super(bankAccount);
    }

    @Override
    public void info() {
        System.out.println("Индивидуальный предприниматель");
        System.out.println("Баланс ИИ: " + getBankAccount());
        System.out.println("Дата создания аккаунта: " + createTime + "\n");
    }

    @Override
    public void putMoney(double money) {
        double commission;
        if (money < 1000) {
            commission = money / 100;
            System.out.println("Вы положили: " + money + "\nКоммисия: " + commission);
            setBankAccount(getBankAccount() + (money - commission));
            System.out.print("Баланс: ");
            System.out.println(getBankAccount() + "\n");
        }

        if (money >= 1000) {
            commission = (0.5 * money) / 100;
            System.out.println("Вы положили: " + money + "\nКоммисия: " + commission);
            setBankAccount(getBankAccount() + (money - commission));
            System.out.print("Баланс: ");
            System.out.println(getBankAccount() + "\n");
        }
    }
}
