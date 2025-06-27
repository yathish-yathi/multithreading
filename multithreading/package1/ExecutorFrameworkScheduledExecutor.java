import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutorFrameworkScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);
        System.out.println("Scheduling task to run");

        // scheduledExecutor.schedule(()->{
        //     System.out.println("Task running...");
        // }, 3000, TimeUnit.MILLISECONDS);

        // System.out.println("scheduleAtFixedRate task to run");
        // scheduledExecutor.scheduleAtFixedRate(()->{
        //     System.out.println("Task running...");
        // }, 3000,3000, TimeUnit.MILLISECONDS);

        // System.out.println("scheduleWithFixedDelay task to run");
        // scheduledExecutor.scheduleWithFixedDelay(()->{
        //     System.out.println("Task running...");
        // }, 3000, 3000, TimeUnit.MILLISECONDS);


         
        ScheduledFuture<String> ScheduledFuture = scheduledExecutor.schedule(()->{
            System.out.println("Task running...");
            return "hello";
        }, 1000, TimeUnit.MILLISECONDS);
        
        try {
            System.out.println("ScheduledFuture result: " + ScheduledFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // Let the task run a few times
        scheduledExecutor.shutdown();
    }
}
