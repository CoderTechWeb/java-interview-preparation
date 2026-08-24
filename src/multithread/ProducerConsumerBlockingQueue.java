package multithread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue {

    private final BlockingQueue<Integer> queue =
            new ArrayBlockingQueue<>(5);

    static void main(String[] args) {
        ProducerConsumerBlockingQueue buffer = new ProducerConsumerBlockingQueue();

        Thread producer = new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                buffer.produce(i);
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                buffer.consume();
            }
        });
        producer.start();
        consumer.start();

    }

    public synchronized void produce(int value){
        try {
            queue.put(value);
            System.out.println("Produced: " + value);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

    public synchronized int consume() {
        try {
            int value = queue.take();
            System.out.println("Consumed: " + value);
            return value;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1;
        }
    }
}
