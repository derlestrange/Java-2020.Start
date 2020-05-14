import BankClients.*;

public class Main {
    public static void main(String[] args) {

        //физическое лицо
        NaturalPerson naturalPerson = new NaturalPerson(0);
        naturalPerson.info();
        naturalPerson.putMoney(100);
        naturalPerson.takeMoney(10);
        naturalPerson.info();
        System.out.println("========================\n");

        //юридическое лицо
        LegalPerson legalPerson = new LegalPerson(0);
        legalPerson.info();
        legalPerson.putMoney(100);
        legalPerson.takeMoney(10);
        legalPerson.takeMoney(10);
        legalPerson.takeMoney(10);
        legalPerson.takeMoney(10);
        legalPerson.takeMoney(10);
        legalPerson.takeMoney(10);
        naturalPerson.info();
        System.out.println("\n========================\n");


        //индивидуальный предприниматель
        SoleTrader soleTrader = new SoleTrader(0);
        soleTrader.info();
        soleTrader.putMoney(100);
        soleTrader.putMoney(1000);
        naturalPerson.info();
    }
}
