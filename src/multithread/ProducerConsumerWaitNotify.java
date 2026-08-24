package multithread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerWaitNotify {

    static void main(String[] args) {
        ProducerConsumerWaitNotify buffer = new ProducerConsumerWaitNotify();

        Thread produce = new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                buffer.produce(i);
            }
        });

        Thread consume = new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                buffer.consume();
            }
        });
        produce.start();
        consume.start();

    }

    Queue<Integer> queue = new LinkedList<>();
    int capacity = 5;
    public synchronized void produce(int value){
        while (queue.size() == capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        queue.offer(value);
        System.out.println("Produced : " + value);
        notifyAll();
    }

    public synchronized int consume(){
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return -1;
            }
        }
        Integer val = queue.poll();
        System.out.println("Consumeed : " + val);
        notifyAll();
        return val;
    }

}
