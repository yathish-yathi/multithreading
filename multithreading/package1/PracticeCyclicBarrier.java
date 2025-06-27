import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class PracticeCyclicBarrier {

    public static void main(String[] args) {

        Integer numberOfSubSystems = 3;

        CyclicBarrier barrier = new CyclicBarrier(numberOfSubSystems,()->{
            System.out.println(Thread.currentThread().getName()+" All subsystems have completed their tasks, proceeding with the next step.");
        });

        Thread webServer = new Thread(new SubSystem("webServer", 2000, barrier));
        Thread DataBase = new Thread(new SubSystem("DataBase", 3000, barrier));
        Thread messagingService = new Thread(new SubSystem("messagingService", 5000, barrier));
        //new Thread(new SubSystem("4", 10000, barrier)).start();
        
        webServer.start();
        DataBase.start();
        messagingService.start();

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // Main thread sleeps for 2 seconds to allow subsystems to start
        barrier.reset(); // Resetting the barrier for future use if needed

        System.out.println("End of main");    }
    
}

class SubSystem implements Runnable{

    private String name;
    private Integer waitTime;
    private CyclicBarrier barrier;

    public SubSystem(String name, Integer waitTime, CyclicBarrier barrier) {
        this.name = name;
        this.waitTime = waitTime;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println("SubSystem "+name+" is running in thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(waitTime); // Simulating some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("SubSystem "+name+" has completed its task in thread: " + Thread.currentThread().getName()+", waiting at barrier for others to complete...");  
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        } 
        System.out.println("SubSystem "+name+" moving out " + Thread.currentThread().getName());  
        
    }
    
}
