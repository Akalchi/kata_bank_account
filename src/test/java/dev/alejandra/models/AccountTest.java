package dev.alejandra.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(5000, 5);
    }

    @Test
    void testDeposit() {
        account.deposit(2000);
        assertEquals(7000, account.balance);
    }

    @Test 
    void testDepositNegativeAmount() {
        account.deposit(-10);
        assertEquals(5000, account.balance);
    }

}
