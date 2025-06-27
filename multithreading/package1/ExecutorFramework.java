import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorFramework {
    public static void main(String[] args) {

        Long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 9; i++) {
            final int taskId = i;
            executor.submit(()-> runTask(taskId));
            System.out.println("Task " + taskId + " submitted in thread: " + Thread.currentThread().getName());
        }

        executor.shutdown();

        try {
            executor.awaitTermination(3000,TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
           System.out.println("Executor interrupted: " + e.getMessage());
        }

        //executor.shutdown();
        //executor.shutdownNow();

        Long timetaken = System.currentTimeMillis() - startTime;
        System.out.println("All tasks completed in thread: " + Thread.currentThread().getName()+" in "+timetaken);
    }

    public static void runTask(int i) {
        System.out.println(i + " Task started in thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Thread "+i+" interrupted: " + e.getMessage());
        }
        System.out.println(i +" Task completed in thread: " + Thread.currentThread().getName());
    }
}
