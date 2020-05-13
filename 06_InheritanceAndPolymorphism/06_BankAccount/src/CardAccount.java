public class CardAccount extends Account {

    private static double commission = 1;

    public CardAccount(double bankAccount) {
        super(bankAccount);
    }

    @Override
    public void takeMoney(double money) {
        commission = (money * commission) / 100;
        System.out.println("Коммиссия: " + commission);
        if (getBankAccount() > commission){
            System.out.println("Недостаточно средств для списания!");
            return;
        }
        super.takeMoney(money);
        System.out.println("Баланс: " + (getBankAccount() - commission));
    }
}
