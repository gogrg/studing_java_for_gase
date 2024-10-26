package account;

import java.math.BigDecimal;

public interface Account {
    BigDecimal balance = null;
    String name = null;

    void replenishBalance(BigDecimal amount);
    BigDecimal getBalance();
    String getName();
    void printData();


}
