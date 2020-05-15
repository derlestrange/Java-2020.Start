package BankClients;

import java.time.LocalDate;

//юридическое лицо
public class LegalPerson extends Client {

    private static final LocalDate createTime = LocalDate.now();

    public LegalPerson(double bankAccount) {
        super(bankAccount);
    }

    @Override
    public void info() {
        System.out.println("Юридическое лицо лицо");
        System.out.println("Баланс юр. лица: " + getBankAccount());
        System.out.println("Дата создания аккаунта: " + createTime + "\n");
    }

    @Override
    public void takeMoney(double money) {
        double commission = money / 100;
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
