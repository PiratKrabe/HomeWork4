package Alexey_efimenko.HW4.HW4_1.BankSystem;

/**
 * Created by Linkin on 05.03.2017.
 */
public class ChinaBank extends Bank {


    public ChinaBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    int getLimitOfWithdrawal() {
        int withdrawal = 0;
        if (getCurrency().equals(Currency.USD)) {
            withdrawal = 100;
        } else if (getCurrency().equals(Currency.EUR)) {
            withdrawal = 150;
        }
        return withdrawal;
    }

    @Override
    int getLimitOfFunding() {
        int limit = 0;
        if (getCurrency().equals(Currency.EUR)) {
            limit = 5000;
        } else if (getCurrency().equals(Currency.USD)) {
            limit = 10000;
        }
        return limit;
    }

    @Override
    int getMonthlyRate() {
        int monthlyRate = 0;
        if (getCurrency().equals(Currency.USD)) {
            monthlyRate = 1;
        } else if (getCurrency().equals(Currency.EUR)) {
            monthlyRate = 0;
        }
        return monthlyRate;
    }

    @Override
    int getCommission(int summ) {
        int commision = 0;
        if (getCurrency().equals(Currency.USD)) {
            if (summ < 1000) {
                commision = 3;
            } else if (summ > 1000) {
                commision = 5;
            }
        } else if (getCurrency().equals(Currency.EUR)) {
            if (summ < 1000) {
                commision = 10;
            } else if (summ > 1000) {
                commision = 11;
            }
        }
        return commision;
    }
}
