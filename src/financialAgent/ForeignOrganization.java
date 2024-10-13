package financialAgent;

import account.*;
import countries.*;

import java.math.BigDecimal;

public class ForeignOrganization extends FinancialAgent {
    private AllCountries country;

    public ForeignOrganization(String name, AllCountries country) {
        super(name, TypeAgent.FOREIGN_ORGANIZATION, BigDecimal.valueOf(20), country);

        try{
            FriendlyCountries.valueOf(country.name());
            setTax(BigDecimal.valueOf(10));
        }catch  (IllegalArgumentException e){

        }
        try{
            NeutralCountries.valueOf(country.name());
        } catch (IllegalArgumentException e){
            setTax(BigDecimal.valueOf(20));
        }
        try{
            setTax(BigDecimal.valueOf(30));
        }catch  (IllegalArgumentException e){

        }

        this.country = country;
    }

    public AllCountries getCountry() {return country;}


}
