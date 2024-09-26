import agent.*;
import financialSystem.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Person Aleks = new Person("Aleks", "Black", "Potov");
        Aleks.getDebitAccount().setBalance(BigDecimal.valueOf(1500));

        outputPerson(Aleks);

        TaxSystem tax = new TaxSystem();

        IP ipASD = new IP("ip ASD", BigDecimal.valueOf(1000000));

        System.out.println("Sum operation = 500");

        tax.replenshmentAccount(Aleks, ipASD, BigDecimal.valueOf((500)));

        outputPerson(Aleks);

        outputIP(ipASD);

        Ao aoQWERTY = new Ao("AO QWERTY", 5);

        System.out.println("Sum operation = 1100");

        tax.replenshmentAccount(Aleks, aoQWERTY, BigDecimal.valueOf(1100));

        outputPerson(Aleks);

        outputAO(aoQWERTY);

        for (int i = 0; i < 3; i++)
        {
            System.out.println("");
        }

        System.out.println("Summary comission out operation = " + tax.getBankAccount());
        System.out.println("Comission out IP = 20%");
        System.out.println("Comission out AO = 33%");
    }


    public static void outputPerson(Person finAgent){
        for (int i = 0; i < 3; i++)
        {
            System.out.println("");
        }
        System.out.println("Person :" + finAgent.getName() + " " + finAgent.getSurname() + " " + finAgent.getPatronimic());
        System.out.println("Accounts:");
        System.out.println("Debit account: ");
        System.out.println(finAgent.getDebitAccount().getName() + ": " + finAgent.getDebitAccount().getBalance());
        System.out.println("Credit account: ");
        System.out.println(finAgent.getCreditAccount().getName() + ": balance: " + finAgent.getCreditAccount().getBalance());
        System.out.println("Credit limit:" + finAgent.getCreditAccount().getCreditLimit());
        System.out.println("Credit debt: " + finAgent.getCreditAccount().getCreditLimit().subtract(finAgent.getCreditAccount().getBalance()));
    }

    public static void outputIP(IP finAgent){
        for (int i = 0; i < 3; i++)
        {
            System.out.println("");
        }
        System.out.println("Person :" + finAgent.getName());
        System.out.println("Accounts:");
        System.out.println("Debit account: ");
        System.out.println(finAgent.getDebitAccount().getName() + ": balance: " + finAgent.getDebitAccount().getBalance());
        System.out.println("Property value: " + finAgent.getPropertyValue());
    }

    public static void outputAO(Ao finAgent){
        for (int i = 0; i < 3; i++)
        {
            System.out.println("");
        }
        System.out.println("Person :" + finAgent.getName());
        System.out.println("Accounts:");
        System.out.println("Debit account: ");
        System.out.println(finAgent.getDebitAccount().getName() + ": balance: " + finAgent.getDebitAccount().getBalance());
        System.out.println("Number of Participants: " + finAgent.getNumberOfParticipants());

    }
}
