public class DP9 {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount(1, 10000.0f);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 10; i++) {
                    double amount = Math.round(Math.random() * 10000);
                    if (a1.removeMoney(amount)) {
                        System.out.println("Successfully removed: " + amount);
                    } else {
                        System.out.println("Low Balance");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 10; i++) {
                    double amount = Math.round(Math.random() * 10000);
                    a1.addMoney(amount);
                    System.out.println("Added: " + amount);
                }
            }
        });

        t1.start();
        t2.start();
    }
}

class BankAccount {
    int account_id;
    double balance;

    BankAccount(int account_id, double balance) {
        this.account_id = account_id;
        this.balance = balance;
    }

    public synchronized void addMoney(double amount) {
       balance += amount;
    }

    public synchronized boolean removeMoney(double amount) {
        if (balance - amount  < 0)
            return false;
        balance -= amount;
        return true;
    }

    public void getBalance() {
        System.out.println("balance: " + balance);
    }
}