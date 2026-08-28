package thread;

public class TwoThread {

    static void main(String[] args) throws InterruptedException {
        Runnable r1 = ()-> {
            for (int i = 0; i <= 50; i++) {
                System.out.println(i);
            }
        };

        Runnable r2 = ()-> {
            for (int i = 51; i < 50; i++) {
                System.out.println(i);
            }
        };

        Thread thread = new Thread(r1);
        Thread thread1 = new Thread(r2);

        thread.start();
        thread.join();
        thread1.start();

    }
}
