package account;

import java.math.BigDecimal;

public class CreditAccount extends DebitAccount{
    private BigDecimal creditLimit;

    public CreditAccount() {
        super(BigDecimal.valueOf(15000), "Credit acoount");
        this.creditLimit = BigDecimal.valueOf(15000);
    }

    public void setCreditLimit(BigDecimal creditLimit) {this.creditLimit = creditLimit;}

    public BigDecimal getCreditLimit() {return this.creditLimit;}

    public BigDecimal getDebt() {return creditLimit.subtract(balance);}

    @Override
    public void printData(){
        System.out.println("Credit account details:");
        System.out.println("Name account: " + name);
        System.out.println("Balance account: " + balance);
        System.out.println("Credit limit: " + creditLimit);
        System.out.println("Debt: " + getDebt());
    }
}
