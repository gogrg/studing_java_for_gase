package financialAgent;

import countries.*;

import java.math.BigDecimal;

public class ForeignOrganization extends FinancialAgent {

    public ForeignOrganization(String name, Country country) {
        super(name, TypeAgent.FOREIGN_ORGANIZATION, BigDecimal.valueOf(20), country);
        this.country = country;
    }
}
