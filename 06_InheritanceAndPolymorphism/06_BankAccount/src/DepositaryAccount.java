import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositaryAccount extends Account {

    private static final LocalDate today = LocalDate.now();
    private static LocalDate dayOfLastDeposit = today;

    public DepositaryAccount(double bankAccount) {
        super(bankAccount);
    }

    @Override
    public void putMoney(double money) {
        if (money <= 0) {
            return;
        }
        dayOfLastDeposit = today.plusMonths(1);
        super.putMoney(money);
    }

    @Override
    public void takeMoney(double money) {
        if (money <= 0) {
            System.out.println("Некорректный ввод, попробуй снова\n");
            return;
        }
        if (getBankAccount() >= money) {
            long period = ChronoUnit.DAYS.between(today, dayOfLastDeposit);
            if (dayOfLastDeposit.isAfter(today)) {
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
