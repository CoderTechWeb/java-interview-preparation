package multithread;

import java.util.concurrent.CompletableFuture;

public class ExceptionallyExample {

    static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("Something went wrong");
            }
            return "success";
        });

        future.exceptionally(ex -> {
            System.out.println("Handling error: " + ex.getMessage());
            return "Default Value";
        });
    }




}
