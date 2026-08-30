package multithread;

public class BankAccount {

    private int balance = 10000;

    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " tying to withdraw " + amount);

        if (amount <= balance) {
            System.out.println(
                    Thread.currentThread().getName() +
                            " withdrawing " + amount
            );

            balance -= amount;
            System.out.println(
                    Thread.currentThread().getName() +
                            " withdrawing " + amount
            );
        } else {
            System.out.println(
                    Thread.currentThread().getName() +
                            " insufficient balance"
            );
        }
    }

    public int getBalance() {
        return balance;
    }

    static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount();

        Thread[] threads = new Thread[13];

        for (int i = 0; i < 13; i++) {
            threads[i] = new Thread(() -> {
                bankAccount.withdraw(1000);
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(
                "Final Balance = " +
                        bankAccount.getBalance()
        );
    }
}
