package com.company;

public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    // Constructors
    public Customer(String f, String l) {
        this.firstName = f;
        this.lastName = l;
        setAccount(new Account(0)); // Make new customer's account with 0 initial balance
    }

    // Getters
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Account getAccount() {
        return this.account;
    }

    // Setters
    public void setAccount(Account acct) {
        this.account = acct;
    }

    public void setFirstName(String f) {
        this.firstName = f;
    }

    public void setLastName(String l) {
        this.lastName = l;
    }

    public void setName(String f, String l) {
        setFirstName(f);
        setLastName(l);
    }

    // Methods
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
