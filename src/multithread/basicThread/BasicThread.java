package multithread.basicThread;

public class BasicThread {

    static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Hi"));
        thread.start();

        MyWorkerThread thread1 = new MyWorkerThread("Worker-1");
        MyWorkerThread thread2 = new MyWorkerThread("worker-1");

        thread1.start();
        thread2.start();
    }
}
