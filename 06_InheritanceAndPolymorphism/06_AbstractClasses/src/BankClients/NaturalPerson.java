package BankClients;

//физическое лицо
public class NaturalPerson extends Client {

    public NaturalPerson(double bankAccount) {
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
