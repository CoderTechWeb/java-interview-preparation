package multithread;

public class PrintOddAndEven {

    private static final int MAX = 10;
    private static int number = 1;


    static void main(String[] args) {
        PrintOddAndEven printOddAndEven = new PrintOddAndEven();
        Thread oddThread = new Thread(printOddAndEven::printOdd, "odd-Thread");
        Thread evenThread = new Thread(printOddAndEven::printEven, "even-Thread");

        oddThread.start();
        evenThread.start();
    }

    public synchronized void printOdd(){

        while (number <= MAX) {
            while (number % 2 == 0 && number < MAX) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().getName();
                    return;
                }
            }

            if(number <= MAX) {
                System.out.println(
                        Thread.currentThread().getName()
                                + " -> " + number
                );

                number++;
                notifyAll();
            }
        }
    }

    public synchronized void printEven(){
        while (number <= MAX) {
            while (number %2 != 0 && number <= MAX) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().getName();
                    return;
                }
            }

            if(number <= MAX) {
                System.out.println(Thread.currentThread().getName()
                        + " -> " + number);
                number++;
                notifyAll();
            }
        }
    }

}
