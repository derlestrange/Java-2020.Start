import Accounts.*;

public class Main {
    public static void main(String[] args) {

        //account
        System.out.println("Расчетный счет\n");
        Account account = new Account(0);
        account.setBankAccount(10);
        System.out.println("Баланс: " + account.getBankAccount());
        account.putMoney(10);
        account.takeMoney(1);
        System.out.println("Баланс: " + account.getBankAccount());
        System.out.println("\n===========================\n");

        //depositaryAccount
        System.out.println("Депозитарный счет\n");
        DepositaryAccount depositaryAccount = new DepositaryAccount(100);
        //depositaryAccount.putMoney(100);
        depositaryAccount.takeMoney(10);
        depositaryAccount.putMoney(1);
        depositaryAccount.takeMoney(12);
        System.out.println("\n===========================\n");

        //cardAccount
        System.out.println("Карточный счет\n");
        CardAccount cardAccount = new CardAccount(0);
        cardAccount.putMoney(100);
        cardAccount.takeMoney(10);
        cardAccount.takeMoney(10);
        cardAccount.takeMoney(10);
        cardAccount.takeMoney(10);
    }
}
