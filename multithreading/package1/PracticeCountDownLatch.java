import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class PracticeCountDownLatch {
    

    public static void main(String args[]){

        Integer numberOfTask = 6;

        ExecutorService executor = Executors.newFixedThreadPool(2);

        CountDownLatch latch = new CountDownLatch(numberOfTask);

        Future<Integer> future1 = executor.submit(new DependentClass(latch));
        Future<Integer> future2 = executor.submit(new DependentClass(latch));
        Future<Integer> future3 = executor.submit(new DependentClass(latch));
        Future<Integer> future4 = executor.submit(new DependentClass(latch));
        Future<Integer> future5 = executor.submit(new DependentClass(latch));
        Future<Integer> future6 = executor.submit(new DependentClass(latch));

        // try {
        //     latch.await();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        try {
            latch.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        System.out.println("End of main method");
    }


}

class DependentClass implements Callable<Integer> {

    private final CountDownLatch latch;

    public DependentClass(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Task started in thread: " + Thread.currentThread().getName());
        Thread.sleep(2000); // Simulating some work
         System.out.println("Task ended in thread: " + Thread.currentThread().getName());
        latch.countDown();
        return 42;
    }

}