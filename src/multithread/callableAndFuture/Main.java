package multithread.callableAndFuture;

import java.util.concurrent.*;

public class Main {

    static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CalculateSumTask task = new CalculateSumTask(10);

        System.out.println("Main thread submitting the task...");

        Future<Integer> future = executorService.submit(task);

        try {
            // 6. Retrieve the actual result using futureResult.get()
            // WARNING: .get() blocks the main thread until the Callable finishes execution.
            Integer finalResult = future.get();

            System.out.println("Task finished! The calculated sum is: " + finalResult);

            Callable<Integer> task1 = ()->{
                Thread.sleep(1000);
                return 10 + 20;
            };

            Future<Integer> future2 = executorService.submit(task1);
            try {
                Integer res = future2.get();
                System.out.println("Task Finished! final : " + res);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("An error occurred during execution: " + e.getMessage());
        } finally {
            // 7. Always shut down the executor service to stop the application cleanly
            executorService.shutdown();
        }

    }
}
