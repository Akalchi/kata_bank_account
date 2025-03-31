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

}
