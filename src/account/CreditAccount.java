package account;

import java.math.BigDecimal;

public class CreditAccount implements Account {
    private BigDecimal creditLimit;
    private BigDecimal balance;
    private String name;

    public CreditAccount() {
        balance = BigDecimal.valueOf(15000);
        name = "Credit account";
        this.creditLimit = BigDecimal.valueOf(15000);
    }

    public CreditAccount(BigDecimal creditLimit, String name) {
        balance = creditLimit;
        this.creditLimit = creditLimit;
        this.name = name;
        this.creditLimit = BigDecimal.valueOf(15000);
    }

    public void replenishBalance(BigDecimal amount) {this.balance = balance.add(amount);}

    public BigDecimal getBalance() {return this.balance;}

    public String getName() {return this.name;}

    public void setCreditLimit(BigDecimal creditLimit) {this.creditLimit = creditLimit;}

    public BigDecimal getCreditLimit() {return this.creditLimit;}

    public BigDecimal getDebt() {return creditLimit.subtract(balance);}

    public void printData(){
        System.out.println("Credit account details:");
        System.out.println("Name account: " + name);
        System.out.println("Balance account: " + balance);
        System.out.println("Credit limit: " + creditLimit);
        System.out.println("Debt: " + getDebt());
    }
}
