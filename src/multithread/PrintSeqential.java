package multithread;

public class PrintSeqential {

    private final int MAX = 10;
    private int number = 1;

    static void main(String[] args) {

        PrintSeqential seq = new PrintSeqential();
        Thread thread = new Thread(() -> seq.printNumber(1), "T1");
        Thread thread1 = new Thread(() -> seq.printNumber(2), "T2");
        Thread thread2 = new Thread(() -> seq.printNumber(0), "T3");

        thread.start();
        thread1.start();
        thread2.start();
    }

    public synchronized void printNumber(int threadId){
        while(number <= MAX) {
            while (number % 3 != threadId && number <= MAX) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            if (number <= MAX) {
                System.out.println(Thread.currentThread().getName() + " -> " + number);
                number++;
                notifyAll();
            }
        }
    }
}
