package financialAgent;

import countries.*;

import java.math.BigDecimal;

public class ForeignOrganization extends FinancialAgent {
    private Country.TypeCountry countryType;

    public ForeignOrganization(String name, Country country, Country.TypeCountry typeCountry) {
        super(name, TypeAgent.FOREIGN_ORGANIZATION, BigDecimal.valueOf(20), country, typeCountry);
        this.country = country;
        this.countryType = typeCountry;
    }

    public Country.TypeCountry getCountryType() {return countryType;}


}
