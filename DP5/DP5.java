import java.util.HashMap;
import java.util.Scanner;

public class DP5 {
    static HashMap<Integer, BankAccount> accounts =
        new HashMap<Integer, BankAccount>();

    public static void addAccount(int accountNumber, int type) {
        switch (type) {
            case 1:
                accounts.put(
                    accountNumber, 
                    new SavingsAccount(accountNumber, 0)
                );
                break;
            case 2:
                accounts.put(
                    accountNumber, 
                    new CurrentAccount(accountNumber, 0)
                );
                break;
        }
    }
    public static void main(String[] args) {
        int an = 1001;
        String menu = "\n" + 
            "1. Create a new bank account \n" +
            "2. Add money to the account \n" +
            "3. Withdraw money from account \n" +
            "4. Transfer money to bank account \n" + 
            "5. Get the balance \n" +
            "6. Exit \n" +
            "Enter your choice: ";
        String menu2 = 
            "Type of bank account: \n" + 
            "   1. Savings account \n" + 
            "   2. Current account \n" + 
            "Enter your choice: ";
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.print(menu);
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.print(menu2);
                    int type = sc.nextInt();
                    addAccount(an, type);
                    System.out.println("Your account no is " + an++);
                    break;
                }
                case 2: {
                    System.out.print("Enter the account_no: ");
                    int account_number = sc.nextInt();
                    System.out.print("Enter the amount: ");
                    float amount = sc.nextFloat();    
                    try {
                        if (amount < 0) {
                            throw new InsufficientFundsException(
                                "Invalid amount:" + 
                                " cannot deposit negative amount"
                            );
                        } else {
                            if (!accounts.containsKey(account_number)) {
                                throw new InvalidAccountException(
                                    "Invalid account number"
                                );
                            }                            
                            accounts.get(account_number).deposit(amount);
                        }
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    } catch (InvalidAccountException e) {
                        System.out.println(e.getMessage());
                    }
                
                    break;
                }
                case 3: {
                    System.out.print("Enter the account_no: ");
                    int account_number = sc.nextInt();
                    System.out.print("Enter the amount: ");
                    float amount = sc.nextFloat();    
                    try {
                        if (!accounts.containsKey(account_number))
                            throw new InvalidAccountException(
                                "Invalid account number"
                            );
                        if (!accounts.get(account_number).withdraw(amount))
                            throw new InsufficientFundsException(
                                "Low Balance"
                            );
                    } catch (
                        InsufficientFundsException |
                        InvalidAccountException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 4: {
                    System.out.print("Enter the account_no: ");
                    int account_number = sc.nextInt();
                    System.out.print("Enter 2nd account_no: ");
                    int r_account_number = sc.nextInt();
                    System.out.print("Enter the amount: ");
                    float amount = sc.nextFloat();
                    try {
                        if (!accounts.containsKey(r_account_number)) {
                            throw new InvalidAccountException(
                                "Invalid account number"
                            );
                        }                    
                        if (!accounts.get(account_number)
                            .transfer(
                                accounts.get(r_account_number),
                                amount
                            )) 
                            throw new InsufficientFundsException(
                                "Low Balance"
                            );
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    } catch (InvalidAccountException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 5: {
                    System.out.print("Enter the account_no: ");
                    int account_number = sc.nextInt();
                    try {
                        if (!accounts.containsKey(account_number)) {
                            throw new InvalidAccountException(
                                "Invalid account number"
                            );
                        } else {
                            System.out.println(
                                "balance: " +
                                accounts.get(account_number).getBalance()
                            );
                        }
                    } catch (InvalidAccountException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 6: {
                    sc.close();
                    isRunning = false;
                    break;
                }
            }
        }
    }
}

class BankAccount {
    int account_id;
    float balance;

    public BankAccount(int account_id, float balance) {
        this.account_id = account_id;
        this.balance = balance;
    }
    
    public float getBalance() {
        return balance;
    }

    public float getAccountId() {
        return account_id;
    }

    public void deposit(float amount) {
        System.out.println("Depositing: " + amount +
            " In account " + account_id);
        balance += amount;
    }

    public boolean withdraw(float amount) {
        if (amount > balance) {
            System.out.println("Low balance: "
                + balance +
                " Can't withdraw");
            return false;
        }
        System.out.println("withdrawing: " + amount +
            " From: " + account_id);
        balance -= amount;
        return true;
    }

    public boolean transfer(BankAccount account, float amount) {
        if (amount > balance) {
            System.out.println("Low balance: " + balance + " Can't transfer");
            return false;
        }
        System.out.println("transfering: " + amount +
            "\nFrom: " + account_id +
            "\nTo: " + account.account_id);
        account.balance += amount;
        balance -= amount;
        return true;
    }
}

class SavingsAccount extends BankAccount {
    static int max_transactions = 10, max_withdraws = 10;
    int transactions = 0;
    int withdraws = 0;

    SavingsAccount(int account_id, float balance) {
        super(account_id, balance);
    }

    @Override
    public boolean withdraw(float amount) {
        if (withdraws == max_withdraws) {
            System.out.println("number of withdraws exceeded");
            return false;
        }
        withdraws++;
        return super.withdraw(amount);
    }

    @Override
    public boolean transfer(BankAccount account, float amount) {
        if (transactions == max_transactions) {
            System.out.println("number of transfers exceeded");
            return false;
        }
        transactions++;
        return super.transfer(account, amount);
    }
}

class CurrentAccount extends BankAccount {
    CurrentAccount(int account_id, float balance) {
        super(account_id, balance);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidAccountException extends Exception {
    public InvalidAccountException(String message) {
        super(message);
    }
}