package agent;

import account.DebitAccount;

public class FinancialAgent {

    protected TypeAgent type;
    protected String name;
    protected DebitAccount debitAccount;

    FinancialAgent(TypeAgent type, String name)
    {
        this.type = type;
        this.name = name;
        this.debitAccount = new DebitAccount();
    }

    public TypeAgent getTypeAgent() {return type;}

    public void setName(String name) {this.name = name;}

    public String getName() {return name;}

    public DebitAccount getDebitAccount() {return debitAccount;}
}
