package dev.alejandra.models;

public class Account {

    protected double balance;
    protected int numDeposits = 0;
    protected int numWithdrawals = 0;
    protected double annualRate;
    protected double monthlyFee = 0.0;

    public Account(double balance, double annualRate) {
        this.balance = balance;
        this.annualRate = annualRate;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            numDeposits++;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            numWithdrawals++;
        }
    }

    public void calculateMonthlyInterest() {
        double monthlyInterest = (annualRate / 12) * balance / 100;
        balance += monthlyInterest;
    }

}
