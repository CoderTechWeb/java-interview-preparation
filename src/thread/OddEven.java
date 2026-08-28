package thread;

public class OddEven {
   private int start = 1;
   private final int limit = 10;

   public synchronized void printEven() {
       while (start <= limit) {
           while (start % 2 != 0 && start <= limit) {
               try {
                   wait();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }

           if (start <= limit){
               System.out.println("Even Thread : " + start);
               start++;
               notifyAll();
           }
       }
   }

   public synchronized void printOdd() {
       while (start <= limit) {
           while (start % 2 == 0 && start <= limit) {
               try {
                   wait();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
           if (start <= limit) {
               System.out.println("Odd Thread : " + start);
               start++;
               notifyAll();
           }
       }
   }

    static void main(String[] args) {

        OddEven oddEven = new OddEven();

        Thread evenThread = new Thread(oddEven::printEven);
        Thread oddThread = new Thread(oddEven::printOdd);
        evenThread.start();
        oddThread.start();
    }
}
