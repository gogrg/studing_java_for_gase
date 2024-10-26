import countries.*;
import financialAgent.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        //основные участники
        Person aleks = new Person("Aleks", "Black", "Yow");
        Person piter = new Person("Piter", "Brown", "Wow");
        Organization ooo = new Organization(BigDecimal.valueOf(100), "Some organization", BigDecimal.valueOf(23));
        Organization aoo = new Organization(BigDecimal.valueOf(200), "Some second organization", BigDecimal.valueOf(19));
        ForeignOrganization foreignOrganization1 = new ForeignOrganization("First foreign organization", Country.USA, Country.TypeCountry.HOSTILE);
        ForeignOrganization foreignOrganization2 = new ForeignOrganization("Second foreign organization", Country.BELARUS, Country.TypeCountry.FRIENDLY);
        ForeignOrganization foreignOrganization3 = new ForeignOrganization("Third foreign organization", Country.EGYPT, Country.TypeCountry.NEUTRAL);
        //налоговая
        TaxSystem taxSystem = new TaxSystem();

        BigDecimal sumPay1 = BigDecimal.valueOf(100);
        BigDecimal sumPay2 = BigDecimal.valueOf(1000);
        BigDecimal sumPay3 = BigDecimal.valueOf(5000);
        BigDecimal plantar = BigDecimal.valueOf(10000);

        aleks.getDebitAccount().replenishBalance(plantar);

        taxSystem.transaction(aleks, piter, sumPay2);

        taxSystem.transaction(aleks, ooo, sumPay2);
        taxSystem.transaction(aleks, aoo, sumPay2);

        taxSystem.transaction(aleks, foreignOrganization1, sumPay2);
        taxSystem.transaction(aleks, foreignOrganization2, sumPay2);
        taxSystem.transaction(aleks, foreignOrganization3, sumPay2);

        taxSystem.transaction(ooo, piter, sumPay1);
        taxSystem.transaction(ooo, aoo, sumPay1);

        taxSystem.transaction(foreignOrganization1, foreignOrganization2, sumPay1);

        taxSystem.transaction(foreignOrganization1, piter, sumPay1);
        taxSystem.transaction(foreignOrganization2, piter, sumPay1);
        taxSystem.transaction(foreignOrganization3, piter, sumPay1);

        taxSystem.transaction(piter, ooo, sumPay1);
        taxSystem.transaction(piter, ooo, sumPay3);
    }
}
