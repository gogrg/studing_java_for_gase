package financialAgent;

import account.*;

import java.math.BigDecimal;

import countries.Country;

public abstract class FinancialAgent {
    protected String name;
    protected DebitAccount debitAccount;
    protected TypeAgent typeAgent;
    protected BigDecimal tax;
    protected Country country;

    public FinancialAgent(String name, TypeAgent typeAgent, BigDecimal tax) {
        this.name = name;
        this.typeAgent = typeAgent;
        this.tax = tax;
        this.debitAccount = new DebitAccount();
        this.country = Country.RUSSIA;
    }

    public String getName() {
        return name;
    }

    public DebitAccount getDebitAccount() {
        return debitAccount;
    }

    public TypeAgent getTypeAgent() {
        return typeAgent;
    }

    public BigDecimal getTax() {
        return tax;
    }

    protected boolean pay(BigDecimal amount) {
        if (this.debitAccount.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < 0) {
            return false;
        } else {
            this.debitAccount.replenishBalance(amount.multiply(BigDecimal.valueOf(-1)));
            return true;
        }
    }

    public void printData() {
        System.out.println("Name: " + this.name);
        System.out.println("Type agent: " + this.typeAgent);
        System.out.println("Country: " + this.country);
        System.out.println("Type country: " + this.country.getTypeCountry());
        System.out.println("Tax: " + this.tax);
        debitAccount.printData();
    }
}
