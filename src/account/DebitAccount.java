package account;

//разбить на классы дебетовая и кредитная, кредитную сделать наследником дебетовой

import java.math.BigDecimal;



public class Account {
    private BigDecimal balance;
    private String name;
    private typeAccount type;

    public Account()
    {
        balance = BigDecimal.ZERO;
        name = "";
        type = typeAccount.DEBIT;
    }

    public Account(BigDecimal balance, String name, typeAccount type)
    {
        this.balance = balance;
        this.name = name;
        this.type = type;
    }

    public void setBalance(BigDecimal balance) {this.balance = balance;}

    public BigDecimal getBalance() {return balance;}

    public void setName(String name) {this.name = name;}

    public String getName() {return name;}

    public typeAccount getType() {return type;}

    public void setType(typeAccount type) {this.type = type;}
}
