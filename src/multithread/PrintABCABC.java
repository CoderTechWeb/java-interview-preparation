package multithread;

public class PrintABCABC {
    private final int MAX = 10;
    private static int number = 1;

    static void main(String[] args) {

        PrintABCABC printABCABC = new PrintABCABC();

        Thread t1 = new Thread(() -> printABCABC.print(1, 'A'), "T1");
        Thread t2 = new Thread(() -> printABCABC.print(2, 'B'), "T2");
        Thread t3 = new Thread(() -> printABCABC.print(0, 'C'), "T3");
        t1.start();
        t2.start();
        t3.start();
    }

    private synchronized  void print(int threadId, char ch) {
        while (number <= MAX) {
            while (number % 3 != threadId && number <= MAX) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            if(number <= MAX) {
                System.out.println(ch);
                number++;
                notifyAll();
            }
        }
    }

}
