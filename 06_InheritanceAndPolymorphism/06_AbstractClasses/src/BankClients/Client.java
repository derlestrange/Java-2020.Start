package BankClients;

public abstract class Client {

    private static double bankAccount;

    Client (double bankAccount){
        Client.bankAccount = bankAccount;
    }

    public abstract void putMoney(double money);
    public abstract void takeMoney(double money);

    public double getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(double bankAccount) {
        Client.bankAccount = bankAccount;
    }
}
