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
        // Checks if amount deposited is greater than 0
        if (amt < 0) {
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
