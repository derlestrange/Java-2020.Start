public class CardAccount extends Account {

    private static double commission = 1;

    public CardAccount(double bankAccount) {
        super(bankAccount);
    }

    @Override
    public void takeMoney(double money) {
        commission = (money * commission) / 100;
        System.out.println("Коммиссия: " + commission);
        super.takeMoney(money);
        System.out.println("Баланс: " + (getBankAccount() - commission));
    }
}
