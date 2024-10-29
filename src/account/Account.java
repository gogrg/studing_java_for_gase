package account;

import java.math.BigDecimal;

public interface Account {
    void replenishBalance(BigDecimal amount);

    BigDecimal getBalance();

    void printData();

    void setName(String name);
}
