package financialAgent;

import account.*;
import java.math.BigDecimal;
import countries.AllCountries;

public abstract class FinancialAgent {
    protected String name;
    protected DebitAccount debitAccount;
    protected TypeAgent typeAgent;
    protected BigDecimal tax;
    protected AllCountries country;

    public FinancialAgent(){
        name = "no name";
        DebitAccount debitAccount = new DebitAccount();
    }

    public FinancialAgent(String name, TypeAgent typeAgent, BigDecimal tax) {
        this.name = name;
        this.typeAgent = typeAgent;
        this.tax = tax;
        debitAccount = new DebitAccount();
        this.country = AllCountries.RUSSIA;
    }

    public FinancialAgent(String name, TypeAgent typeAgent, BigDecimal tax, AllCountries country) {
        this.name = name;
        this.typeAgent = typeAgent;
        this.tax = tax;
        debitAccount = new DebitAccount();
        this.country = country;
    }

    public String getName(){return name;}
    public DebitAccount getDebitAccount(){return debitAccount;}
    public TypeAgent getTypeAgent(){return typeAgent;}
    public BigDecimal getTax(){return tax;}
    public AllCountries getCountry(){return country;}
    protected void setTax(BigDecimal tax){this.tax = tax;}

    public void printData(){
        System.out.println("Name: " + name);
        System.out.println("Type agent: " + typeAgent);
        System.out.println("Country: " + country);
        System.out.println("Tax: " + tax);
        debitAccount.printData();
    }
}
