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

    public void monthlyStatement() {
        balance -= monthlyFee;
        calculateMonthlyInterest();
    }

    public void print() {
       
        StringBuilder output = new StringBuilder();
        output.append("Balance: ").append(balance).append("\n");
        output.append("Number of Deposits: ").append(numDeposits).append("\n");
        output.append("Number of Withdrawals: ").append(numWithdrawals).append("\n");
        output.append("Annual Rate: ").append(annualRate).append("\n");
        output.append("Monthly Fee: ").append(monthlyFee).append("\n");
    
        System.out.print(output.toString());
    }

}
