package financialAgent;

import account.*;

import java.math.BigDecimal;

public class Person extends FinancialAgent {
    final private String patronymic;
    final private String surname;
    final private CreditAccount creditAccount;

    public Person(String name, String surname, String patronymic) {
        super(name, TypeAgent.PERSON, BigDecimal.valueOf(13));
        this.patronymic = patronymic;
        this.surname = surname;
        creditAccount = new CreditAccount();
    }

    public CreditAccount getCreditAccount() {
        return creditAccount;
    }

    @Override
    public boolean pay(BigDecimal amount) {
        if (this.debitAccount.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) >= 0) {
            this.debitAccount.replenishBalance(amount.multiply(BigDecimal.valueOf(-1)));
        } else {
            this.creditAccount.replenishBalance(amount.multiply(BigDecimal.valueOf(-1)));
        }
        return true;
    }

    public boolean replenishCreditAccount(BigDecimal amount) {
        if (this.debitAccount.getBalance().compareTo(amount) >= 0) {
            this.debitAccount.replenishBalance(amount);
            pay(amount);
            return true;
        }
        return false;
    }

    @Override
    public void printData() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Patronimic: " + patronymic);
        System.out.println("Type agent: " + typeAgent);
        System.out.println("Country: " + country);
        System.out.println("Type country: " + this.country.getTypeCountry());
        System.out.println("Tax: " + tax);
        debitAccount.printData();
        creditAccount.printData();
    }
}
