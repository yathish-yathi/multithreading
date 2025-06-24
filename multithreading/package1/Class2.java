public class Class2 implements Runnable {

    @Override
    public void run() {
        // for(;;){

        //      System.out.println(Thread.currentThread().getName());
             
        // }

        System.out.println("open "+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        System.out.println("close "+Thread.currentThread().getName());
        
    }
    
}
