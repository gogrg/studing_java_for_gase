import countries.*;
import financialAgent.*;
import account.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        //основные участники
        Person aleks = new Person("Aleks", "Black", "Yow");
        Person piter = new Person("Piter", "Brown", "Wow");
        Organization ooo = new Organization(BigDecimal.valueOf(100), "Some organization", BigDecimal.valueOf(23));
        Organization aoo = new Organization(BigDecimal.valueOf(200), "Some second organization", BigDecimal.valueOf(19));
        ForeignOrganization foreignOrganization1 = new ForeignOrganization("First foreign organization", AllCountries.USA);
        ForeignOrganization foreignOrganization2 = new ForeignOrganization("Second foreign organization", AllCountries.BELARUS);
        ForeignOrganization foreignOrganization3 = new ForeignOrganization("Third foreign organization", AllCountries.EGYPT);
        //налоговая
        TaxSystem taxSystem = new TaxSystem();

        aleks.getDebitAccount().replenishBalance(BigDecimal.valueOf(10000));

        taxSystem.transaction(aleks, piter, BigDecimal.valueOf(100));

        taxSystem.transaction(aleks, ooo, BigDecimal.valueOf(1000));
        taxSystem.transaction(aleks, aoo, BigDecimal.valueOf(1000));

        taxSystem.transaction(aleks, foreignOrganization1, BigDecimal.valueOf(1000));
        taxSystem.transaction(aleks, foreignOrganization2, BigDecimal.valueOf(1000));
        taxSystem.transaction(aleks, foreignOrganization3, BigDecimal.valueOf(1000));

        taxSystem.transaction(ooo, piter, BigDecimal.valueOf(100));
        taxSystem.transaction(ooo, aoo, BigDecimal.valueOf(100));

        taxSystem.transaction(foreignOrganization1, foreignOrganization2, BigDecimal.valueOf(100));

        taxSystem.transaction(foreignOrganization1, piter, BigDecimal.valueOf(100));
        taxSystem.transaction(foreignOrganization2, piter, BigDecimal.valueOf(100));
        taxSystem.transaction(foreignOrganization3, piter, BigDecimal.valueOf(100));

        taxSystem.transaction(piter, ooo, BigDecimal.valueOf(1000));
    }
}
