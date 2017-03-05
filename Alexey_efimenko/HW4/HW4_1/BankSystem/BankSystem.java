package Alexey_efimenko.HW4.HW4_1.BankSystem;

import Alexey_efimenko.HW4.HW4_1.UserSystem.User;

/**
 * Created by Linkin on 05.03.2017.
 */
public interface BankSystem {
    void withdrawOfUser(User user, int amount);

    void fundUser(User user, int amount);

    void transferMoney(User fromUser, User toUser, int amount);

    void paySalary(User user);
}
