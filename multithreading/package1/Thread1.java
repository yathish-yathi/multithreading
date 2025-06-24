public class Thread1 extends Thread {

    public Thread1(String name){
        super(name);
    }

    public void run(){
        //System.out.println(Thread.currentThread().getName());


        for(int i=0; i<=5; i++){
            System.out.println(Thread.currentThread().getName() + " => " + i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }

        //System.out.println("close "+Thread.currentThread().getName());
    }


}
