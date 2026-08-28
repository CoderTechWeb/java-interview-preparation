package thread;

public class OddEven {
    private int number = 1;
    private int limit = 10;

    public synchronized void printEven() throws InterruptedException {
        while(number <= limit) {

            while(number % 2 != 0 && number <= limit){
                wait();
            }

            if (number <= limit) {
                System.out.println("Even Thread : " + number);
                number++;
                notifyAll();
            }

        }
    }

    public synchronized void printOdd() throws InterruptedException {
        while (number <= limit) {
            while (number % 2 == 0 && number <= limit){
                wait();
            }

            if (number <= limit) {
                System.out.println("Odd Thread : " + number);
                number++;
                notifyAll();
            }
        }
    }

    static void main(String[] args) {
        OddEven oddEven = new OddEven();

        Thread evenThread = new Thread(() -> {
            try {
                oddEven.printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread oddThread = new Thread(() -> {
            try {
                oddEven.printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        evenThread.start();
        oddThread.start();
    }
}
