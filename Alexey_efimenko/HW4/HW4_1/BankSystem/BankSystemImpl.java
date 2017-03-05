package Alexey_efimenko.HW4.HW4_1.BankSystem;

import Alexey_efimenko.HW4.HW4_1.UserSystem.User;

import java.math.BigDecimal;

/**
 * Created by Linkin on 05.03.2017.
 */
public class BankSystemImpl implements BankSystem {

    @Override
    public void withdrawOfUser(User user, int amount) {

        if (amount <= 0) {
            System.out.println("WTF?");
            return;
        }
        if (amount > user.getBank().getLimitOfWithdrawal()) {
            System.out.println("Withdrawal limit is :" + user.getBank().getLimitOfWithdrawal() + " .Please try again");
            return;
        }
        double valueCommision = amount * user.getBank().getCommission(amount) / 100;
        if (user.getBalance() < amount + valueCommision) {
            System.out.println("Don't have that kind of money");
            return;
        }
        double secondBalance = user.getBalance();

        user.setBalance(new BigDecimal(user.getBalance() - amount - valueCommision).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        System.out.println("Balance " + secondBalance + "; withdraw: " + amount + "; commision: " + valueCommision + "; Balance after withdraw: " + user.getBalance());

    }

    @Override
    public void fundUser(User user, int amount) {
        if (amount <= 0) {
            System.out.println("Wtf?? ");
            return;
        }
        if (amount > user.getBank().getLimitOfFunding()) {
            System.out.println("Funding limit is " + user.getBank().getLimitOfFunding() + " .Please try again");
            return;
        }
        double secondBalance = user.getBalance();
        user.setBalance(user.getBalance() + amount);
        System.out.println("Balance : " + secondBalance + " / Ammount of funding : " + amount + " / Final balance: " + user.getBalance());
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (amount <= 0) {
            System.out.println("WTF????? ");
            return;
        }
        double valueCommision = amount * fromUser.getBank().getCommission(amount) / 100;
        if (fromUser.getBalance() < amount + valueCommision) {
            System.out.println(" Don't have that kind of money ");
            return;
        }
        double ammontTransferMoney = 0;
        if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency()) {
            System.out.println("Currency is sent does not match ");
        } else
            ammontTransferMoney = amount;
        if (ammontTransferMoney > toUser.getBank().getLimitOfFunding()) {
            System.out.println("Limit of funding is : " + toUser.getBank().getLimitOfFunding() + " /Please try again");
            return;
        }
        fromUser.setBalance(new BigDecimal(fromUser.getBalance() - ammontTransferMoney - valueCommision).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        toUser.setBalance(new BigDecimal(toUser.getBalance() + ammontTransferMoney - valueCommision).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        System.out.println("User " + fromUser.getName() + " send " + amount + " commision is " + valueCommision + " after balance is :" + fromUser.getBalance());
        System.out.println("User " + toUser.getName() + " take money from: " + fromUser.getName() + " . Balance after founding : " + toUser.getBalance());
    }

    @Override
    public void paySalary(User user) {
        user.setBalance(user.getBalance() + user.getSalary());
        System.out.println("Balance from user " + user.getName() + " after pay salary : " + user.getBalance());
    }
}
