package Accounts;

public class CardAccount extends Account {

    public CardAccount(double bankAccount) {
        super(bankAccount);
    }

    @Override
    public void takeMoney(double money) {
        double commission = money / 100;
        if (money > getBankAccount()) {
            System.out.println("Недостаточно средств для списания!");
            System.out.println("Баланс: " + getBankAccount());
            return;
        }
        if (commission > (getBankAccount() - money)) {
            System.out.println("Недостаточно средств для списания с учетом комиссии 1%.");
            System.out.println("Комиссия: " + commission + ", Сумма списания: " + money + "\n");
            System.out.println("Баланс: " + getBankAccount());
        } else {
            System.out.println("Вы сняли: " + money);
            System.out.println("Комиссия: " + commission);
            setBankAccount(getBankAccount() - (money + commission));
            System.out.println("Баланс: " + getBankAccount());
        }
    }
}
