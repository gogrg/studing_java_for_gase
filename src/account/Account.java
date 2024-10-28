package account;

import java.math.BigDecimal;

public interface Account {
    void replenishBalance(BigDecimal amount);
    BigDecimal getBalance();
    String getName();
    void printData();
}
