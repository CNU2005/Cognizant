// Exercise 41: Executor Service and Callable

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceCallable {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futures = new ArrayList<>();

        
        for (int i = 1; i <= 5; i++) {
            final int n = i;
            Callable<Integer> task = () -> {
                Thread.sleep(100); // simulate work
                return n * n;
            };
            futures.add(executor.submit(task));
        }

        
        try {
            for (int i = 0; i < futures.size(); i++) {
                Integer result = futures.get(i).get();
                System.out.println("Task " + (i + 1) + " result (square): " + result);
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error collecting result: " + e.getMessage());
        } finally {
            executor.shutdown();
        }

        System.out.println("All tasks completed.");
    }
}
