package com.company;

public class Account {
    private double balance;

    // Constructor
    public Account(double init_balance) {
        this.balance = init_balance;
    }

    // Getters
    public double getBalance() {
        return this.balance;
    }

    // Methods
    public boolean deposit(double amt) {
        // Checks if total balance will be greater than the max value of the double data type
        if ((this.balance + amt) > Double.MAX_VALUE) {
            return false;
        } else {
            this.balance += amt;
            return true;
        }
    }

    public boolean withdraw(double amt) {
        // Checks if amount to be withdrawn is greater than the account's balance
        if (amt > this.balance) {
            return false;
        } else {
            this.balance -= amt;
            return true;
        }
    }
}
