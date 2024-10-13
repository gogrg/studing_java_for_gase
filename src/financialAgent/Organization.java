package financialAgent;

import account.*;
import java.math.BigDecimal;

public class Organization extends FinancialAgent{
    private int numberBoughtShare;
    private BigDecimal priceShare;

    public Organization(BigDecimal priceShare, String name, BigDecimal tax){
        super(name, TypeAgent.ORGANIZATION, tax);
        this.numberBoughtShare = 0;
        this.priceShare = priceShare;
    }

    private void upNumberBoughtShare(){numberBoughtShare++;}

    public int getNumberBoughtShare() {return numberBoughtShare;}
    public BigDecimal getPriceShare() {return priceShare;}
    public int numberBoughtShare() {return numberBoughtShare;}
    public void buyShare(Person person, TaxSystem taxSystem){
        taxSystem.transaction(person, this, priceShare);
        numberBoughtShare++;
    }

    @Override
    public void printData(){
        System.out.println("Name: " + name);
        System.out.println("Type agent: " + typeAgent);
        System.out.println("Price share: " + priceShare);
        System.out.println("Number of bought share: " + numberBoughtShare);
        System.out.println("Country: " + country);
        System.out.println("Tax: " + tax);
        debitAccount.printData();

    }
}
