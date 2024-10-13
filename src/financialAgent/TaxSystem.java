package financialAgent;

import account.DebitAccount;
import java.math.BigDecimal;
import countries.*;

public class TaxSystem{
    private DebitAccount account;

    public TaxSystem(){
        account = new DebitAccount();
    }

    private boolean checkBalanceAgent(FinancialAgent finAgent, BigDecimal sumOfMoney){
        return !(finAgent.getDebitAccount().getBalance().subtract(sumOfMoney).compareTo(sumOfMoney) < 1);
    }

    public void transaction(Person finAgent1, FinancialAgent finAgent2, BigDecimal sumOfMoney) {
        String message = "";
        //между людьми
        if (finAgent2.getTypeAgent() == TypeAgent.PERSON){
            if (checkBalanceAgent(finAgent1, sumOfMoney)){
                finAgent1.getDebitAccount().replenishBalance(sumOfMoney.multiply(BigDecimal.valueOf(-1)));
                finAgent2.getDebitAccount().replenishBalance(sumOfMoney);
                printTransactionData(true, finAgent1, finAgent2, BigDecimal.ZERO, sumOfMoney, message);
                return;
            }
            else{
                printTransactionData(false, finAgent1, finAgent2, BigDecimal.ZERO, sumOfMoney, message);
                return;
            }
        }
        //стандартный перевод
        if (checkBalanceAgent(finAgent1, sumOfMoney)){
            finAgent1.getDebitAccount().replenishBalance(sumOfMoney.multiply(BigDecimal.valueOf(-1)));
            finAgent2.getDebitAccount().replenishBalance(sumOfMoney.multiply(BigDecimal.valueOf(1).subtract(finAgent2.getTax().divide(BigDecimal.valueOf(100)))));
            this.account.replenishBalance(sumOfMoney.multiply(finAgent2.getTax().divide(BigDecimal.valueOf(100))));
        }
        else{
            finAgent1.getCreditAccount().replenishBalance(sumOfMoney.multiply(BigDecimal.valueOf(-1)));
            finAgent2.getDebitAccount().replenishBalance(sumOfMoney.multiply(BigDecimal.valueOf(1).subtract(finAgent2.getTax().divide(BigDecimal.valueOf(100)))));
            this.account.replenishBalance(sumOfMoney.multiply(finAgent2.getTax().divide(BigDecimal.valueOf(100))));
        }
        printTransactionData(true, finAgent1, finAgent2, sumOfMoney.multiply(finAgent2.getTax().divide(BigDecimal.valueOf(100))), sumOfMoney, message);
    }


    //пришлось всё таки делать разные методы, потому что проблема не в том, что кредитный аккаунт не может заменить дебетовый(он может),
    //а ,потому что предок FinancialAgent не содержит поле CreditAccount
    public void transaction(FinancialAgent finAgent1, FinancialAgent finAgent2, BigDecimal sumOfMoney){
        String message = "";

        //между иностранными организациями не наша юрисдикция
        if(finAgent1.getTypeAgent() == TypeAgent.FOREIGN_ORGANIZATION && finAgent2.getTypeAgent() == TypeAgent.FOREIGN_ORGANIZATION){
            message = "Transaction between foreign organization. It out of our jurisdiction";
            printTransactionData(false, finAgent1, finAgent2, sumOfMoney.multiply(finAgent2.getTax().divide(BigDecimal.valueOf(100))), sumOfMoney,message);
            return;
        }
        //переводы от иностранной организации
        else if (finAgent1.getTypeAgent() == TypeAgent.FOREIGN_ORGANIZATION){
            try {
                HostileCountries.valueOf(finAgent1.getCountry().name());
                message = "Warning! ," + finAgent2.getName() + " is inagent!";
            }
            catch  (IllegalArgumentException e){
            }

        }
        //стандартный перевод
        if (checkBalanceAgent(finAgent1, sumOfMoney)){
            finAgent1.getDebitAccount().replenishBalance(sumOfMoney.multiply(BigDecimal.valueOf(-1)));
            finAgent2.getDebitAccount().replenishBalance(sumOfMoney.multiply(BigDecimal.valueOf(1).subtract(finAgent2.getTax().divide(BigDecimal.valueOf(100)))));
            this.account.replenishBalance(sumOfMoney.multiply(finAgent2.getTax().divide(BigDecimal.valueOf(100))));
            printTransactionData(true, finAgent1, finAgent2, sumOfMoney.multiply(finAgent2.getTax().divide(BigDecimal.valueOf(100))), sumOfMoney,message);
            return;
        }

        printTransactionData(false, finAgent1, finAgent2, sumOfMoney.multiply(finAgent2.getTax().divide(BigDecimal.valueOf(100))), sumOfMoney,message);

    }

    public void printTransactionData(boolean isSuccess, FinancialAgent finAgent1, FinancialAgent finAgent2, BigDecimal tax ,BigDecimal sumOfMoney, String message){

        if (isSuccess){
            message += "Transaction successful. transaction " + String.valueOf(sumOfMoney) + " from " + finAgent1.getName() + " to " + finAgent2.getName();

            System.out.println(message);
            System.out.println("result transaction: ");
            finAgent1.printData();
            for (int i = 0; i < 2; i++){
                System.out.println();
            }
            finAgent2.printData();
            System.out.println();
            System.out.println("Tax out this transaction: " + tax);
            printData();
            for (int i = 0; i < 5; i++){
                System.out.println();
            }
        }
        else{
            if (message.isEmpty()){
                message += "Transaction failed: not enough money. Transaction " + String.valueOf(sumOfMoney) + " from " + finAgent1.getName() + " to " + finAgent2.getName();
            }

            System.out.println(message);
            for (int i = 0; i < 5; i++){
                System.out.println();
            }
        }
    }

    public void printData(){
        System.out.println("Amount tax - " + account.getBalance());
    }
}
