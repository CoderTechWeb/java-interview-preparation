package multithread;

public class PrintNumbers {

    private static int number = 1;

    static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();
        Thread t1 = new Thread(() -> printNumbers.print(1), "Thread-1");
        Thread t2 = new Thread(() -> printNumbers.print(2), "Thread-2");
        Thread t3 = new Thread(() -> printNumbers.print(0), "Thread-3");
        t1.start();
        t2.start();
        t3.start();
    }

    public synchronized void print(int threadId) {
        while (number <= 100) {
            while(number <= 100 && number % 3 != threadId) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            if(number <= 100) {
                System.out.println(number);
                number++;
                notifyAll();
            }
        }


    }
}
