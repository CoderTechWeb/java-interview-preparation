package multithread.callableAndFuture;

import java.util.concurrent.Callable;

public class CalculateSumTask implements Callable {

    private final int number;

    public CalculateSumTask(int number){
        this.number = number;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is calculated sum to " + number);

        int sum = 0;

        for (int i = 1; i < number; i++) {
            sum += i;
            Thread.sleep(100);
        }

        return sum;
    }
}
