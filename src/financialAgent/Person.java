package financialAgent;

import account.*;
import java.math.BigDecimal;

public class Person extends FinancialAgent{
    private String patronimic;
    private String surname;
    private CreditAccount creditAccount;

    public Person(String name, String surname, String patronimic){
        super(name, TypeAgent.PERSON, BigDecimal.valueOf(13));
        this.patronimic = patronimic;
        this.surname = surname;
        creditAccount = new CreditAccount();
    }

    public String getPatronimic(){return patronimic;}
    public String getSurname(){return surname;}
    public CreditAccount getCreditAccount(){return creditAccount;}

    @Override
    public boolean pay(BigDecimal amount) {
        if (this.debitAccount.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) >= 0){
            this.debitAccount.replenishBalance(amount.multiply(BigDecimal.valueOf(-1)));
            return true;
        }
        else{
            this.creditAccount.replenishBalance(amount.multiply(BigDecimal.valueOf(-1)));
            return true;
        }
    }

    @Override
    public void printData(){
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Patronimic: " + patronimic);
        System.out.println("Type agent: " + typeAgent);
        System.out.println("Country: " + country);
        System.out.println("Type country: " + typeCountry);
        System.out.println("Tax: " + tax);
        debitAccount.printData();
        creditAccount.printData();
    }
}
