package account;

import java.math.BigDecimal;

public class DebitAccount {
    protected BigDecimal balance;
    protected String name;


    public DebitAccount()
    {
        balance = BigDecimal.ZERO;
        name = "Debit account";
    }

    public DebitAccount(BigDecimal balance, String name)
    {
        this.balance = balance;
        this.name = name;
    }

    public void setBalance(BigDecimal balance) {this.balance = balance;}

    public BigDecimal getBalance() {return balance;}

    public void setName(String name) {this.name = name;}

    public String getName() {return name;}
}
