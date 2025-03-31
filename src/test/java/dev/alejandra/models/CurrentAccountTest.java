package dev.alejandra.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CurrentAccountTest {

      @Test
     void testWithdrawCreatesOverdraft() {
         CurrentAccount account = new CurrentAccount(5000, 5);
         account.withdraw(6000);
         assertEquals(0, account.balance);
         assertEquals(1000, account.getOverdraft());
     } 

}
