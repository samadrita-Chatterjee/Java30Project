/*Create a Java program that simulates a bank account. The program should allow
users to deposit and withdraw money, check their balance 
 */



package in.ineuron.test;

import java.util.Scanner;

public class BankAccount04 {
    private String accountNumber;
    private double balance;

    public BankAccount04(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println(" Please enter a positive value.");
            return;
        }
        balance += amount;
        System.out.println("Deposit of " + amount + " successful.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Please enter a positive value.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawal of " + amount + " successful.");
    }

    public void checkBalance() {
        System.out.println("Account Balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        BankAccount04 account = new BankAccount04(accountNumber);

        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the bank account program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}
