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
        System.out.println("Вы сняли: " + money);
        System.out.println("Комиссия: " + commission);
        setBankAccount(getBankAccount() - (commission + money));
    }
}
