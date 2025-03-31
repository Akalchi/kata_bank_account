package dev.alejandra.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
     void testCannotDepositWhenIsInactive() {
         SavingAccount account = new SavingAccount(5000, 5);
         account.deposit(2000);
         assertEquals(5000, account.balance);
     }

    @Test
    void testCannotWithDrawWhenIsInactive() {
         SavingAccount account = new SavingAccount(5000, 5);
         account.withdraw(2000);
         assertEquals(5000, account.balance);
     }

     @Test
     void testFeeForExtraWithdrawals() {
         SavingAccount account = new SavingAccount(15000, 12);
         account.withdraw(2000);
         account.withdraw(2000);
         account.withdraw(2000);
         account.withdraw(2000);
         account.withdraw(2000);
         account.monthlyStatement();
         assertEquals(4040, account.balance);
         assertEquals(1000, account.monthlyFee);
     } 

}
