package financialAgent;

import java.math.BigDecimal;

public class Organization extends FinancialAgent {
    private int numberBoughtShare;
    final private BigDecimal priceShare;

    public Organization(BigDecimal priceShare, String name, BigDecimal tax) {
        super(name, TypeAgent.ORGANIZATION, tax);
        this.numberBoughtShare = 0;
        this.priceShare = priceShare;
    }

    public void buyShare(Person person, TaxSystem taxSystem) {
        numberBoughtShare++;
        taxSystem.transaction(person, this, priceShare);
    }

    @Override
    public void printData() {
        System.out.println("Name: " + name);
        System.out.println("Type agent: " + typeAgent);
        System.out.println("Price share: " + priceShare);
        System.out.println("Number of bought share: " + numberBoughtShare);
        System.out.println("Country: " + country);
        System.out.println("Tax: " + tax);
        debitAccount.printData();

    }
}
