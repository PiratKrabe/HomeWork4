package Alexey_efimenko.HW4.HW4_1.BankSystem;

/**
 * Created by Linkin on 05.03.2017.
 */
public class EUBank extends Bank {


    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    int getLimitOfWithdrawal() {
        int withdrawal = 0;
        if (getCurrency().equals(Currency.USD)) {
            withdrawal = 2000;
        } else if (getCurrency().equals(Currency.EUR)) {
            withdrawal = 2200;
        }
        return withdrawal;
    }

    @Override
    int getLimitOfFunding() {
        int limit = 0;
        if (getCurrency().equals(Currency.EUR)) {
            limit = 20000;
        } else if (getCurrency().equals(Currency.USD)) {
            limit = 10000;
        }
        return limit;
    }

    @Override
    int getMonthlyRate() {
        int monthlyRate = 0;
        if (getCurrency().equals(Currency.USD)) {
            monthlyRate = 0;
        } else if (getCurrency().equals(Currency.EUR)) {
            monthlyRate = 1;
        }
        return monthlyRate;
    }

    @Override
    int getCommission(int summ) {
        int commision = 0;
        if (getCurrency().equals(Currency.USD)) {
            if (summ < 1000) {
                commision = 5;
            } else if (summ > 1000) {
                commision = 7;
            }
        } else if (getCurrency().equals(Currency.EUR)) {
            if (summ < 1000) {
                commision = 2;
            } else if (summ > 1000) {
                commision = 4;
            }
        }
        return commision;
    }
}
