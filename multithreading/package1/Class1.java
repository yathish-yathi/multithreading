public class Class1 extends Thread{
    public static void main(String[] args) {
        // System.out.println("Class1 in package1");
        // System.out.println(Thread.currentThread().getName());

        // Thread1 t1 = new Thread1();
        // System.out.println(t1.getState());
        // t1.start();
        // System.out.println(t1.getState());

        // try {
        //     t1.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        //System.out.println("main code end");

        // Class2 runnable = new Class2();
        // Thread t2 = new Thread(runnable);
        // System.out.println(t2.getName());
        // t2.start();

        // Thread1 mango = new Thread1("Mango");
        // Thread1 apple = new Thread1("Apple");
        // Thread1 banana = new Thread1("Banana");

        // //OR
        // mango.setName("Mango");
        // apple.setName("Apple"); 
        // banana.setName("Banana");

        // apple.setPriority(Thread.MAX_PRIORITY);
        // banana.setPriority(Thread.NORM_PRIORITY);
        // mango.setPriority(Thread.MIN_PRIORITY);

        // mango.start();
        // apple.start();  
        // banana.start();

        // Class1 t1 = new Class1();
        // t1.start();
        // try{
        //         Thread.sleep(1000);
        //     }catch(InterruptedException e){
        //         System.out.println("Thread interrupted: " + e.getMessage());
        //     }

        // t1.interrupt();

        // Class1 t1 = new Class1();
        // t1.start();
    
        System.out.println("code end");
    }

    public void run(){
        System.out.println("Thread started: " + Thread.currentThread().getName());
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                System.out.println("Thread interrupted: " + e);
            }
        }

}
