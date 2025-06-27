

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorFramework2 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            System.out.println("Hello");
            Thread.sleep(2000);
            return 42;
        };

        Runnable run = () -> {
            System.out.println("Hello");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        };

        Future<?> future1 = executor.submit(task);

        Future<?> future2 = executor.submit(run);

        System.out.println("Not End of main method");

         try {
            System.out.println(future2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("End of main method");

        executor.shutdown();
    }
    
}
