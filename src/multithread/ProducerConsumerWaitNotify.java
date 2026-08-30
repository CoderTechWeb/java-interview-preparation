package multithread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerWaitNotify {

    Queue<Integer> queue = new LinkedList<>();
    int capacity = 5;

    public synchronized void produce(int value){
        if (queue.size() == capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        queue.offer(value);
        System.out.println("Produced : " + value);
        notifyAll();
    }

    public synchronized void consume()  {
        if(queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Integer val = queue.poll();
        System.out.println("Consumed : " + val);
        notifyAll();
    }

    static void main(String[] args) {

        ProducerConsumerWaitNotify producerConsumer = new ProducerConsumerWaitNotify();

        Thread produce = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                producerConsumer.produce(i);
            }
        });

        Thread consume = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                producerConsumer.consume();
            }
        });

        produce.start();
        consume.start();
    }
}