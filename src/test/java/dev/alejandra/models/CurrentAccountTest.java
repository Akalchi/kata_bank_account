package dev.alejandra.models;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

     @Test
     void testDepositReducesOverdraft() {
         CurrentAccount account = new CurrentAccount(5000, 5);
         account.withdraw(6000);
         account.deposit(1000);
         assertEquals(0, account.balance);
         assertEquals(0, account.getOverdraft());
     }

     @Test
     void testPrint() {
         CurrentAccount account = new CurrentAccount(15000, 12);
         account.withdraw(2000);
         account.deposit(1000);
     
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
         PrintStream printStream = new PrintStream(outputStream);
         System.setOut(printStream);
     
         account.print();
     
         System.setOut(System.out);
     
         String actualOutput = outputStream.toString()
                 .replace(",", ".")  
                 .replaceAll("\\r\\n|\\r|\\n", "\n")  
                 .trim();  
     
         String expectedOutput = """
                 Balance: 14000.0
                 Monthly Fee: 0.0
                 Total transactions: 2
                 Overdraft: 0.0
                 """.trim(); 
     
         assertEquals(expectedOutput, actualOutput);
     }
     


}
