package account;

import java.math.BigDecimal;

public class CreditAccount extends DebitAccount{
    private BigDecimal creditLimit;

    public CreditAccount() {
        super(BigDecimal.valueOf(15000), "Credit acoount");
        this.creditLimit = BigDecimal.valueOf(15000);
    }

    public CreditAccount(String name, BigDecimal creditLimit) {
        super(creditLimit, name);
        this.creditLimit = creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {this.creditLimit = creditLimit;}

    public BigDecimal getCreditLimit() {return this.creditLimit;}
}
