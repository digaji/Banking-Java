package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomers;
    private String bankName;

    // Constructor
    public Bank(String bName) {
        this.bankName = bName;
        this.customers = new Customer[1];   // Set initial array size as 1
    }

    // Getters
    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    public Customer getCustomer(int index) {
        // Check if index is greater than 0 and less than the total number of customers
        if (index >= 0 && index < getNumOfCustomers()) {
            return this.customers[index];
        } else {
            System.out.println("Index is beyond the amount of customers! Try again.");
            return null;
        }
    }

    public String getBankName() {
        return this.bankName;
    }

    // Methods
    public void addCustomer(String f, String l) {
        if (getNumOfCustomers() != 0) {
            // Create temp ArrayList based on original customers array
            ArrayList<Customer> tempArray = new ArrayList<>(Arrays.asList(this.customers));

            // Add new customer to tempArray
            tempArray.add(new Customer(f, l));

            // Override original customers array with tempArray contents
            this.customers = tempArray.toArray(this.customers);
        } else {
            // If array was still empty (with initial size 1)
            this.customers[0] = new Customer(f, l);
        }
        this.numberOfCustomers += 1;
        // * In hindsight, I should've just made the customers array as an ArrayList
    }

    public void printCustomers() {
        if (getNumOfCustomers() != 0) {
            for (int i = 1; i <= getNumOfCustomers(); i++) {
                System.out.println(i + ". " + this.customers[i - 1]);
            }
            // * I didn't include the customers' balance for "privacy" purposes
        } else {
            System.out.println(getBankName() + " does not have any customers");
        }
    }
}
