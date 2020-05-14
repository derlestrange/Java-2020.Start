package BankClients;

import java.time.LocalDate;

//физическое лицо
public class NaturalPerson extends Client {

    private static final LocalDate createTime = LocalDate.now();

    public NaturalPerson(double bankAccount) {
        super(bankAccount);
    }

    @Override
    public void info() {
        System.out.println("\nФизическое лицо");
        System.out.println("Баланс физ. лица: " + getBankAccount());
        System.out.println("Дата создания аккаунта: " + createTime + "\n");
    }
}
