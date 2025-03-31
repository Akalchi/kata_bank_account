package dev.alejandra.models;

import java.util.Locale;

public class SavingAccount extends Account{

    private boolean active;
 
    public SavingAccount(double balance, double annualRate) {
        super(balance, annualRate);
        this.active = balance>= 10000;

    }

    @Override
    public void deposit(double amount) {
        if (active) {
            super.deposit(amount);
        }
    }

    @Override
     public void withdraw(double amount) {
         if (active) {
             super.withdraw(amount);
         }
     }

     @Override
     public void monthlyStatement() {
         if (numWithdrawals > 4) {
             monthlyFee += (numWithdrawals - 4) * 1000;
             super.monthlyStatement();
         }
         active = balance >= 10000;
     }
     
     @Override
     public void print() {
         System.out.printf(Locale.US, "Balance: %.1f%n", balance);
         System.out.printf(Locale.US, "Monthly Fee: %.1f%n", monthlyFee);
         System.out.printf("Total transactions: %d%n", numWithdrawals);
     } 

}
