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

}
