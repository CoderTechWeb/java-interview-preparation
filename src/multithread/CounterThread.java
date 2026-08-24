package multithread;

public class CounterThread {

    static int count = 0;

    static void main(String[] args) {

        Thread[] thread = new Thread[10];

        for(int i = 0; i < 10; i++) {
            thread[i] = new Thread(()->{
                for(int j = 0; j < 1000; j++) {
                    count++;
                }
            });

            thread[i].start();
        }

        System.out.println("count = " + count);
    }


}
