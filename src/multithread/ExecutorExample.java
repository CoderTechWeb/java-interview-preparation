package multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExample {

    static void main(String[] args) {
        ExecutorExample executorExample = new ExecutorExample();
        executorExample.exercise2();
    }

    // ============================================================
    // 1. Submit 10 tasks to a fixed thread pool
    // ============================================================
    public void exercise1() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().getName();
                }
            });
        }
        executor.shutdown();
    }

    // ============================================================
    // 2. Return results using Future
    // ============================================================

    public void exercise2() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int taskId = i;
            Future<Integer> future = executor.submit(() -> {
                System.out.println(
                        "Executing Task " + taskId +
                                " by " +
                                Thread.currentThread().getName()
                );

                Thread.sleep(1000);

                return taskId;
            });
            futures.add(future);
        }

        for (Future<Integer> future : futures){
            try {
                Integer result = future.get();
                System.out.println("Result = " + result);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                System.out.println("Task failed: " + e.getCause());
            }
        }
        executor.shutdown();
    }

}