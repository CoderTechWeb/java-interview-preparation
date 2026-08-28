package thread;

public class PrintNumberSeq {
    private int number = 1;

    private synchronized void printNumber(int threadId) throws InterruptedException{
        final int numberOfThread = 3;
        final int limit = 10;

        while (number <= limit) {
            while (number <= limit && (number - 1) % numberOfThread != threadId) {
                wait();
            }

            if (number <= limit) {
                System.out.println("Thread - " + (threadId + 1) + " : " + number);
                number++;
                notifyAll();
            }
        }
    }

    static void main(String[] args) {
        PrintNumberSeq printNumberSeq = new PrintNumberSeq();

        for (int i = 0; i < 3; i++) {
            int threadId = i;
            new Thread(() -> {
                try {
                    printNumberSeq.printNumber(threadId);
                }catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }).start();
        }
    }
}