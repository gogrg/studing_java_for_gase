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
    protected Country.TypeCountry typeCountry;

    public FinancialAgent(){
        name = "no name";
        DebitAccount debitAccount = new DebitAccount();
    }

    public FinancialAgent(String name, TypeAgent typeAgent, BigDecimal tax) {
        this.name = name;
        this.typeAgent = typeAgent;
        this.tax = tax;
        this.debitAccount = new DebitAccount();
        this.country = Country.RUSSIA;
        this.typeCountry = Country.TypeCountry.THIS;
    }

    public FinancialAgent(String name, TypeAgent typeAgent, BigDecimal tax, Country country, Country.TypeCountry typeCountry) {
        this.name = name;
        this.typeAgent = typeAgent;
        this.tax = tax;
        debitAccount = new DebitAccount();
        this.country = country;
        this.typeCountry = typeCountry;
    }

    public String getName(){return name;}
    public DebitAccount getDebitAccount(){return debitAccount;}
    public TypeAgent getTypeAgent(){return typeAgent;}
    public BigDecimal getTax(){return tax;}
    public Country getCountry(){return country;}
    protected void setTax(BigDecimal tax){this.tax = tax;}
    protected Country.TypeCountry getTypeCountry(){return typeCountry;}

    protected boolean pay(BigDecimal amount){
        if (this.debitAccount.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < 0){
            return false;
        }
        else{
            this.debitAccount.replenishBalance(amount.multiply(BigDecimal.valueOf(-1)));
            return true;
        }
    }

    public void printData(){
        System.out.println("Name: " + name);
        System.out.println("Type agent: " + typeAgent);
        System.out.println("Country: " + country);
        System.out.println("Type country: " + typeCountry);
        System.out.println("Tax: " + tax);
        debitAccount.printData();
    }
}
