package Accounts;

public class CardAccount extends Account {

    public CardAccount(double bankAccount) {
        super(bankAccount);
    }

    @Override
    public void takeMoney(double money) {

        double commission = (money * 1) / 100;
        if (money > getBankAccount()) {
            System.out.println("Недостаточно средств для списания!");
            System.out.println("Баланс: " + getBankAccount());
            return;
        }
        super.takeMoney(money - commission);
        System.out.println("Комиссия: " + commission);
        setBankAccount(getBankAccount() - commission);
    }
}
