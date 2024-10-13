package account;

import java.math.BigDecimal;

public  class DebitAccount {
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

    public void replenishBalance(BigDecimal balance) {this.balance = this.balance.add(balance);}

    public BigDecimal getBalance() {return balance;}

    public String getName() {return name;}

    public void printData(){
        System.out.println("Debit account details:");
        System.out.println("Name account: " + name);
        System.out.println("Balance account: " + balance);
    }
}
