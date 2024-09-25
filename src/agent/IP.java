package agent;

import java.math.BigDecimal;
import account.*;

public class Individual extends FinancialAgent {

    //стоимость имущества, которое типо под залог долгов бизнеса если чо
    private BigDecimal propertyValue;
    //фамилия
    private String surname;
    //отчество
    private String patronymic;
    //Кредитка
    private CreditAccount thisCreditAccount;

    Individual(){
        super(typeAgent.INDIVIDUAL, "");
        this.propertyValue = new BigDecimal(0);
        this.surname = "";
        this.patronymic = "";
    }

    public Individual(String name, String surname, String patronymic, BigDecimal propertyValue, typeAccount typeAccount){
        super(typeAgent.INDIVIDUAL, name);

        this.surname = surname;
        this.patronymic = patronymic;
        this.propertyValue = propertyValue;
        this.thisCreditAccount = new CreditAccount();

    }

    //изменение стоимости имущества
    void changePropertyValue(BigDecimal propertyValue){this.propertyValue = propertyValue;}

    void setAccountBalance(BigDecimal balance){this.thisAccount.setBalance(balance);}

    BigDecimal getAccountBalance(){return this.thisAccount.getBalance();}

}
