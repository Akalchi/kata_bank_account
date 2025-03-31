package dev.alejandra.models;

public class CurrentAccount extends Account {

    private float overdraft; 
 
    public CurrentAccount(double balance, double annualRate) {
        super(balance, annualRate);
        this.overdraft = 0;
    }

    public float getOverdraft() {
        return overdraft;
    }

    @Override
    public void withdraw(double amount) {
        if(amount <= balance) {
            super.withdraw(amount);
        } else {
            overdraft += amount - balance;
            balance = 0;
            numWithdrawals ++;
        }
    }

    @Override
    public void deposit(double amount) {
        if (overdraft > 0) {
            if(amount >= overdraft) {
                amount -= overdraft;
                overdraft = 0;
                super.deposit(amount);
            } else {
                overdraft -= amount;
                amount = 0;
            }
        }else {
            super.deposit(amount);
        }
    }

}
