import BankClients.*;

public class Main {
    public static void main(String[] args) {

        //физическое лицо
        System.out.println("Физическое лицо\n");
        NaturalPerson naturalPerson = new NaturalPerson(0);
        naturalPerson.putMoney(100);
        naturalPerson.takeMoney(10);
        System.out.println("========================\n");

        //юридическое лицо
        System.out.println("Юридическое лицо\n");
        LegalPerson legalPerson = new LegalPerson(0);
        legalPerson.putMoney(100);
        legalPerson.takeMoney(10);
        legalPerson.takeMoney(10);
        legalPerson.takeMoney(10);
        legalPerson.takeMoney(10);
        legalPerson.takeMoney(10);
        legalPerson.takeMoney(10);
        System.out.println("========================\n");


        //индивидуальный предприниматель
        System.out.println("Индивидуальный предприниматель\n");
        SoleTrader soleTrader = new SoleTrader(0);
        soleTrader.putMoney(100);
        soleTrader.putMoney(1000);
    }
}
