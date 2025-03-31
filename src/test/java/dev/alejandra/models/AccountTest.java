package dev.alejandra.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @Test
    void testWithdraw() {
        account.withdraw(2000);
        assertEquals(3000, account.balance);
    }

    @Test
    void testWithdrawInsufficientFunds() {
        account.withdraw(6000);
        assertEquals(5000, account.balance);
    }

    @Test
    void testCalculateMonthlyInterest() { 
        account.calculateMonthlyInterest();
        assertEquals(5020.83, account.balance, 0.1);
    }

    @Test
    void testMonthlyStatement() {
        account.monthlyStatement();
        assertEquals(5020.83, account.balance, 0.1);
    }

    @Test
     void testPrint() {
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
         PrintStream printStream = new PrintStream(outputStream);
         System.setOut(printStream);
 
         account.print();
 
         String expectedOutput = "Balance: 5000.0\n" +
                 "Number of Deposits: 0\n" +
                 "Number of Withdrawals: 0\n" +
                 "Annual Rate: 5.0\n" +
                 "Monthly Fee: 0.0\n";
 
         assertEquals(expectedOutput, outputStream.toString());
 
         System.setOut(System.out);
     }

}
