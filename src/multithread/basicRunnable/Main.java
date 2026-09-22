package multithread.basicRunnable;

public class Main {

    static void main(String[] args) {

        MyWorkerRunnable task = new MyWorkerRunnable();
        Thread thread = new Thread(task, "RunnableThread-1");
        Thread thread1 = new Thread(task, "RuunableThread-2");

        thread.start();
        thread1.start();

        Thread thread2 = new Thread(() -> System.out.println("hi"));

        thread2.start();
    }
}
