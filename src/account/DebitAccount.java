package account;

import java.math.BigDecimal;

public class DebitAccount implements Account {
    private BigDecimal balance;
    private String name;

    public DebitAccount() {
        this.balance = BigDecimal.ZERO;
        this.name = "DebitAccount";
    }

    public void replenishBalance(BigDecimal balance) {
        this.balance = this.balance.add(balance);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printData() {
        System.out.println("Debit account details:");
        System.out.println("Name account: " + this.name);
        System.out.println("Balance account: " + this.balance);
    }
}
