package ArrayList.Internship;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        bankAccount = account;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (bankAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient funds or invalid amount.");
                    }
                    break;

                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (bankAccount.deposit(depositAmount)) {
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;

                case 3:
                    double balance = bankAccount.checkBalance();
                    System.out.println("Your account balance is: $" + String.format("%.2f", balance));
                    break;

                case 4:
                    System.out.println("Thank you for using our ATM.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial account balance: ");
        double initialBalance = scanner.nextDouble();
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}