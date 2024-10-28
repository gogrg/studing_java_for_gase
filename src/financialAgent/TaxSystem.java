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
        return !(finAgent.getDebitAccount().getBalance().compareTo(sumOfMoney) < 0);
    }

    public void transaction(FinancialAgent finAgent1, FinancialAgent finAgent2, BigDecimal sumOfMoney){
        String message = "";

        boolean resultTransaction = true;

        BigDecimal tax = finAgent2.getTax();

        //между человеками
        if (finAgent2.getTypeAgent() == TypeAgent.PERSON && finAgent2.typeAgent == TypeAgent.PERSON){
            tax = BigDecimal.ZERO;
        }
        //между иностранными организациями не наша юрисдикция
        else if(finAgent1.getTypeAgent() == TypeAgent.FOREIGN_ORGANIZATION && finAgent2.getTypeAgent() == TypeAgent.FOREIGN_ORGANIZATION){
            message = "Transaction between foreign organization. It out of our jurisdiction";
            resultTransaction = false;
            tax = BigDecimal.ZERO;
        }
        //переводы от иностранной организации
        else if (finAgent1.getTypeAgent() == TypeAgent.FOREIGN_ORGANIZATION){
            if (finAgent1.country.getTypeCountry() == TypeCountry.HOSTILE){
                message += finAgent1.getName() + " is inagent";
            }
        }

        BigDecimal sumTax = sumOfMoney.multiply(tax.divide(BigDecimal.valueOf(100)));

        if (finAgent1.pay(sumOfMoney)){
            finAgent2.getDebitAccount().replenishBalance(sumOfMoney.subtract(sumTax));
            this.account.replenishBalance(sumTax);
            printTransactionData(true, finAgent1, finAgent2, sumTax, sumOfMoney,message);
        }
        else{
                printTransactionData(false, finAgent1, finAgent2, sumOfMoney.subtract(sumTax), sumOfMoney, message);
        }
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
