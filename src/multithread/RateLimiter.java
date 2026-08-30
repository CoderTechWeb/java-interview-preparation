package multithread;

//Multiple threads call an API. Implement: maximum 5 requests/second.
public class RateLimiter {

    private final int maxRequests = 5;
    private long windowStart  = System.currentTimeMillis();
    private final long windowSize = 1000;
    private int requestCount = 0;

    public synchronized boolean allowRequest(){
        long currentTime = System.currentTimeMillis();

        if (currentTime - windowStart >= windowSize){
            windowStart = currentTime;
            requestCount = 0;
        }

        if (requestCount >= maxRequests) {
            return false;
        }

        requestCount++;
        return true;
    }

    static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter();

        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {

            int threadId = i + 1;

            threads[i] = new Thread(() -> {
                if (rateLimiter.allowRequest()) {
                    System.out.println("Request allowed - Thread " + threadId);
                } else {
                    System.out.println(
                            "Request rejected - Thread "
                                    + threadId
                    );
                }
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}