package dev.alejandra.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AccountTest {
 @Test
     void testDeposit() {
         Account account = new Account(5000, 5);
         account.deposit(2000);
         assertEquals(7000, account.balance);
     }
}
