package BankClients;

//юридическое лицо
public class LegalPerson extends Client {

    public LegalPerson(double bankAccount) {
        super(bankAccount);
    }

    @Override
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

    @Override
    public void takeMoney(double money) {
        double commission = money / 100;
        if (money < 0 || getBankAccount() < money || (money < 0 && getBankAccount() < money)) {
            System.out.println("Некорректный ввод");
            System.out.println("Баланс: " + getBankAccount() + "\n");
            return;
        }
        System.out.println("Вы сняли: " + money);
        System.out.println("Комиссия: " + commission);
        setBankAccount(getBankAccount() - (commission + money));
    }

}
