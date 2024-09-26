package agent;

import java.math.BigDecimal;

public class IP extends FinancialAgent {

    //стоимость имущества, которое типо под залог долгов бизнеса если чо
    private BigDecimal propertyValue;
    //Кредитка

    public IP(){
        super(TypeAgent.IP, "");
        this.propertyValue = new BigDecimal(0);
    }

    public IP(String name, BigDecimal propertyValue){
        super(TypeAgent.IP, name);

        this.propertyValue = propertyValue;
    }

    //изменение стоимости имущества
    public void changePropertyValue(BigDecimal propertyValue){this.propertyValue = propertyValue;}

    public BigDecimal getPropertyValue(){return this.propertyValue;}
}
