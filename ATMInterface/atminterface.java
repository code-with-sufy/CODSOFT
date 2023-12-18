package ATMInterface;

import java.util.Scanner;

class BankAcc {
    private double bal;

    public BankAcc(double bal) {
        this.bal = bal;
    }

    public double getBalance() {
        return bal;
    }

    public void deposit(double amount) {
        bal += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= bal) {
            bal -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAcc account;
    private Scanner scanner;

    public ATM(BankAcc account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("1. Withdraw amount");
        System.out.println("2. Deposit amount");
        System.out.println("3. Check Balance");
        System.out.println("Choose an option: ");
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                System.out.println("Enter the amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                if (account.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Current balance is: " + account.getBalance());
                } else {
                    System.out.println("Insufficient funds!");
                }
                break;
            case 2:
                System.out.println("Enter the amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                System.out.println("Deposit successful. Current balance is: " + account.getBalance());
                break;
            case 3:
                System.out.println("Your current balance is: " + account.getBalance());
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
}

 class Atminterface {
    public static void main(String[] args) {
        BankAcc userAccount = new BankAcc(1000); // Initial balance
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            atm.displayOptions();
            int option = scanner.nextInt();
            atm.processOption(option);

            System.out.println("Want to perform another transaction? (Yes/No)");
            String continueOption = scanner.next();
            if (!continueOption.equalsIgnoreCase("Y")) {
                exit = true;
                System.out.println("Thank you for using the ATM.Please visit again");
            }
        }
        scanner.close();
    }
}