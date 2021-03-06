package Accounts;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositaryAccount extends Account {

    private static LocalDate dayOfLastDeposit = LocalDate.now();

    public DepositaryAccount(double bankAccount) {
        super(bankAccount);
    }

    @Override
    public void putMoney(double money) {
        if (money <= 0) {
            return;
        }
        dayOfLastDeposit = LocalDate.now().plusMonths(1);
        super.putMoney(money);
    }

    @Override
    public void takeMoney(double money) {
        if (money <= 0) {
            System.out.println("Некорректный ввод, попробуй снова\n");
            return;
        }
        if (getBankAccount() >= money) {
            long period = ChronoUnit.DAYS.between(LocalDate.now(), dayOfLastDeposit);
            if (dayOfLastDeposit.isAfter(LocalDate.now())) {
                System.out.println("Снимать еще нельзя, осталось: " + period + " д.");
                System.out.println(getBankAccount());
            } else {
                super.takeMoney(money);
            }
        } else {
            System.out.println("Некорректный ввод, попробуй снова\n");
        }
        System.out.println("Баланс: " + getBankAccount() + "\n");
    }

    @Override
    public double getBankAccount() {
        System.out.print("Депозиратный счет: ");
        return super.getBankAccount();
    }
}
