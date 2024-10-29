package account;

import java.math.BigDecimal;

public class CreditAccount implements Account {
    private BigDecimal creditLimit;
    private BigDecimal balance;
    private String name;

    public CreditAccount() {
        this.balance = BigDecimal.valueOf(15000);
        this.creditLimit = BigDecimal.valueOf(15000);
        this.name = "Credit account";
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void replenishBalance(BigDecimal amount) {
        this.balance = balance.add(amount);
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDebt() {
        return this.creditLimit.subtract(balance);
    }

    public void printData() {
        System.out.println("Credit account details:");
        System.out.println("Name account: " + this.name);
        System.out.println("Balance account: " + this.balance);
        System.out.println("Credit limit: " + this.creditLimit);
        System.out.println("Debt: " + getDebt());
    }
}
