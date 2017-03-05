package Alexey_efimenko.HW4.HW4_1;

import Alexey_efimenko.HW4.HW4_1.BankSystem.*;
import Alexey_efimenko.HW4.HW4_1.UserSystem.User;

/**
 * Created by Linkin on 05.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        USBank usBankEUR = new USBank(666, "USA", Currency.EUR, 1000, 12000, 2, 1000000);
        USBank usBankUSD = new USBank(777, "USA", Currency.USD, 10, 500, 500, 100000);

        EUBank euBankUSD = new EUBank(999, "Ukraine", Currency.USD, 720, 3000, 1, 999999999);
        EUBank euBankEUR = new EUBank(678920, "Poland", Currency.EUR, 120, 100, 5, 30000000);

        ChinaBank chinaBankUSD = new ChinaBank(3, "China", Currency.USD, 10000, 30, 44444, 6000000);
        ChinaBank chinaBankEUR = new ChinaBank(2, "China", Currency.EUR, 5000, 20, 4443, 5000000);

        User userUSBankUSD = new User(1, "Tramp", 777.66, 3, "WhiteHouse", 1, usBankUSD);
        User userUSBankEUR = new User(2, "George", 5555.66, 4, "CasinoRoyal", 30, usBankEUR);

        User userEUBankUSD = new User(3, "Ira", 5600.25, 5, "Askania", 1000, euBankUSD);
        User userEUBankEUR = new User(4, "Anna", 22600.37, 6, "Ditreid", 8895, euBankEUR);

        User userChinaBankUSD = new User(5, "Oho", 9600.85, 7, "BYD", 2346, chinaBankUSD);
        User userChinaBankEUR = new User(6, "Li", 33000.95, 8, "Chery", 3453, chinaBankEUR);

        BankSystemImpl bankSystem = new BankSystemImpl();

        System.out.println("User name of USBank EUR: " + userUSBankEUR.getName());
        bankSystem.withdrawOfUser(userUSBankEUR, 111);
        bankSystem.fundUser(userUSBankEUR, 222);
        bankSystem.transferMoney(userUSBankEUR, userUSBankUSD, 333);
        bankSystem.paySalary(userUSBankEUR);

        System.out.println("User name of USBank USD: " + userUSBankUSD.getName());
        bankSystem.withdrawOfUser(userUSBankUSD, 700);
        bankSystem.fundUser(userUSBankUSD, 444444);
        bankSystem.transferMoney(userUSBankUSD, userUSBankUSD, 22);
        bankSystem.paySalary(userUSBankUSD);

        System.out.println("User name of  EUBank EUR: " + userEUBankEUR.getName());
        bankSystem.withdrawOfUser(userEUBankEUR, 100);
        bankSystem.fundUser(userEUBankEUR, 30);
        bankSystem.transferMoney(userEUBankEUR, userUSBankEUR, 5);
        bankSystem.paySalary(userEUBankEUR);

        System.out.println("User name of EUBank USD : " + userEUBankUSD.getName());
        bankSystem.withdrawOfUser(userEUBankUSD, -12);
        bankSystem.fundUser(userEUBankUSD, -12);
        bankSystem.transferMoney(userEUBankUSD, userUSBankUSD, 2);
        bankSystem.paySalary(userEUBankUSD);

        System.out.println("User name of ChinaBank EUR: " + userChinaBankEUR.getName());
        bankSystem.withdrawOfUser(userChinaBankEUR, 9999);
        bankSystem.fundUser(userChinaBankEUR, 8888);
        bankSystem.transferMoney(userChinaBankEUR, userEUBankEUR, 131313);
        bankSystem.paySalary(userChinaBankEUR);

        System.out.println("User name of ChinaBank USD: " + userChinaBankUSD.getName());
        bankSystem.withdrawOfUser(userChinaBankUSD, 777);
        bankSystem.fundUser(userChinaBankUSD, 888);
        bankSystem.transferMoney(userChinaBankUSD, userChinaBankEUR, 666);
        bankSystem.paySalary(userChinaBankUSD);

    }
}
