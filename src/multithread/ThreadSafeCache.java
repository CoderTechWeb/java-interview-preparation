package multithread;

import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeCache {
    private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key){
        return cache.get(key);
    }

    public void remove(String key) {
        cache.remove(key);
    }

    public boolean contains(String key) {
        return cache.containsKey(key);
    }

    static void main(String[] args) throws InterruptedException {
        ThreadSafeCache safeCache = new ThreadSafeCache();

        Thread writer1 = new Thread(() -> {
            safeCache.put("user1", "Suresh");
            System.out.println("Writer 1 completed");

        });
        Thread writer2 = new Thread(() -> {
            safeCache.put("user2", "Rajesh");
            System.out.println("Writer 2 completed");

        });

        Thread reader1 = new Thread(() -> {
            System.out.println(
                    "user1 = " + safeCache.get("user1")
            );
        });

        Thread reader2 = new Thread(() -> {
            System.out.println(
                    "user2 = " + safeCache.get("user2")
            );
        });

        writer1.start();
        writer2.start();

        writer1.join();
        writer2.join();


        reader1.start();
        reader2.start();
        reader1.join();
        reader2.join();
    }
}
