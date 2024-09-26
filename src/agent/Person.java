package agent;

import account.CreditAccount;
import account.DebitAccount;

public class Person extends FinancialAgent {

    private String surname;
    private String patronimic;
    private CreditAccount creditAccount;

    public Person(String name, String surname, String patronimic) {
        super(TypeAgent.PERSON, name);
        this.surname = surname;
        this.patronimic = patronimic;
        creditAccount = new CreditAccount();
        debitAccount = new DebitAccount();
    }

    public String getSurname(){return surname;}

    public String getPatronimic(){return patronimic;}

    public CreditAccount getCreditAccount(){return creditAccount;}


}
