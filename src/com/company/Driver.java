package com.company;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        // Variables
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        System.out.println("Welcome to the banking application\n");
        System.out.print("Enter bank's name >> ");
        String bankName = sc.nextLine();

        Bank theBank = new Bank(bankName);

        while (flag) {
            System.out.println("\nBank: " + theBank.getBankName() + "\nChoose from the following options:");
            System.out.println("[1] Add a customer");
            System.out.println("[2] Get number of customers");
            System.out.println("[3] Print list of customers");
            System.out.println("[4] Get a certain customer's data");
            System.out.println("[5] Exit program");

            System.out.print("Enter your choice >> ");
            int choice = sc.nextInt();
            sc.nextLine();  // Throw away next line
            System.out.println();

            switch (choice) {
                // * Add a customer
                case 1 -> {
                    System.out.print("Enter customer's name [First Last] >> ");
                    String[] name = sc.nextLine().split(" ");   // Split whole name at whitespaces

                    theBank.addCustomer(name[0], name[name.length - 1]);
                    System.out.println("Customer: " + name[0] + " " + name[name.length - 1] + " successfully added!");
                }
                // * Get number of customers
                case 2 -> System.out.println("Number of customers: " + theBank.getNumOfCustomers());
                // * Print list of customers
                case 3 -> theBank.printCustomers();
                // * Get a certain customer's data
                case 4 -> {
                    boolean nestedFlag = true;

                    theBank.printCustomers();

                    if (theBank.getNumOfCustomers() != 0) {
                        System.out.print("\nEnter customer's index [index] >> ");
                        Customer chosenCustomer = theBank.getCustomer(sc.nextInt() - 1);
                        sc.nextLine();

                        // Checks if chosenCustomer is actually a real customer or just null
                        if (chosenCustomer != null) {
                            while (nestedFlag) {
                                System.out.println("\nCurrent customer: " + chosenCustomer + " | Balance: " + chosenCustomer.getAccount().getBalance());
                                System.out.println("Choose from the following options:");
                                System.out.println("[1] Deposit");
                                System.out.println("[2] Withdraw");
                                System.out.println("[3] Reset name");
                                System.out.println("[4] Exit from customer");

                                System.out.print("Enter your choice >> ");
                                int nestedChoice = sc.nextInt();
                                sc.nextLine();  // Throw away next line
                                System.out.println();

                                switch (nestedChoice) {
                                    // * Deposit
                                    case 1 -> {
                                        System.out.println("Customer's current balance: " + chosenCustomer.getAccount().getBalance());
                                        System.out.print("Enter amount to be deposited [amount] >> ");

                                        if (chosenCustomer.getAccount().deposit(sc.nextDouble())) {
                                            System.out.println("\nSuccessfully deposited! Customer's current balance is now " + chosenCustomer.getAccount().getBalance());
                                        } else {
                                            System.out.println("\nDeposit unsuccessful! Amount to be deposited too high");
                                        }
                                    }
                                    // * Withdraw
                                    case 2 -> {
                                        System.out.println("Customer's current balance: " + chosenCustomer.getAccount().getBalance());
                                        System.out.print("Enter amount to be withdrawn [amount] >> ");

                                        if (chosenCustomer.getAccount().withdraw(sc.nextDouble())) {
                                            System.out.println("\nSuccessfully withdrawn! Customer's current balance is now " + chosenCustomer.getAccount().getBalance());
                                        } else {
                                            System.out.println("\nWithdraw unsuccessful! Amount to be withdrawn too high");
                                        }
                                    }
                                    // * Reset name
                                    case 3 -> {
                                        System.out.println("Customer's current name: " + chosenCustomer);
                                        System.out.print("Enter customer's new name [First Last] >> ");
                                        String[] newName = sc.nextLine().split(" ");   // Split whole name at whitespaces

                                        chosenCustomer.setName(newName[0], newName[newName.length - 1]);
                                        System.out.println("Successfully renamed customer! Customer's new name is " + chosenCustomer);
                                    }
                                    // * Exit from customer
                                    case 4 -> nestedFlag = false;
                                    default -> System.out.println("Not a choice! Try again.");
                                }
                            }
                        }
                    }
                }
                // * Exit program
                case 5 -> {
                    System.out.println("Goodbye!");
                    flag = false;
                }
                default -> System.out.println("Not a choice! Try again.");
            }
        }
    }
}
