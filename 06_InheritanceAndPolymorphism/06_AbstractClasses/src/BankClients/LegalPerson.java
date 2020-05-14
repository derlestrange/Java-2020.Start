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
        System.out.println("Вы сняли: " + money);
        System.out.println("Комиссия: " + commission);
        setBankAccount(getBankAccount() - (commission + money));
        System.out.println("Баланс: " + getBankAccount() + "\n");
    }
}
