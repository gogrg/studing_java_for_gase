package financialSystem;

import agent.*;

import java.math.BigDecimal;

public class TaxSystem {

    private BigDecimal bankAccount;

    public TaxSystem(){
        bankAccount = new BigDecimal("0.00");
    }

    public void replenshmentAccount(Person finAgent1, FinancialAgent finAgent2, BigDecimal amount){

        if (finAgent1.getTypeAgent() == TypeAgent.PERSON) {
            if (finAgent1.getDebitAccount().getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < 0){
                finAgent1.getCreditAccount().setBalance(finAgent1.getCreditAccount().getBalance().subtract(amount));
            }
            else{
                finAgent1.getDebitAccount().setBalance(finAgent1.getDebitAccount().getBalance().subtract(amount));
            }
        }

        BigDecimal summToBankAccount = new BigDecimal("0.00");
        BigDecimal summToAgent2Account = new BigDecimal("0.00");

        if (finAgent2.getTypeAgent() == TypeAgent.AO){
            summToBankAccount = (amount.multiply(BigDecimal.valueOf(0.33)));
            summToAgent2Account = (amount.multiply(BigDecimal.valueOf(0.67)));
        }
        else if (finAgent2.getTypeAgent() == TypeAgent.IP){
            summToBankAccount = (amount.multiply(BigDecimal.valueOf(0.2)));
            summToAgent2Account = (amount.multiply(BigDecimal.valueOf(0.8)));
        }

        finAgent2.getDebitAccount().setBalance(finAgent2.getDebitAccount().getBalance().add(summToAgent2Account));

        bankAccount = bankAccount.add(summToBankAccount);
    }

    public BigDecimal getBankAccount(){return bankAccount;}


}
