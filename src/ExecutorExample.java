import java.util.concurrent.*;
import java.util.*;

public class ExecutorExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // List of Callable tasks
        List<Callable<String>> tasks = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            tasks.add(() -> {
                Thread.sleep(1000);
                return "Task " + taskId + " completed by " + Thread.currentThread().getName();
            });
        }

        // Submit one task using submit()
        Future<String> singleResult = executor.submit(() -> "Single Task Done");

        // Get result from single task
        System.out.println("Single Task Result: " + singleResult.get());

        // Run all tasks and wait for them to complete
        List<Future<String>> results = executor.invokeAll(tasks);

        // Print results
        for (Future<String> result : results) {
            System.out.println(result.get());
        }

        // Use invokeAny: returns the result of the fastest successful task
        String fastestResult = executor.invokeAny(tasks);
        System.out.println("Fastest result: " + fastestResult);

        // Shutdown the executor
        executor.shutdown();
    }
}