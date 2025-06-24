import java.time.temporal.TemporalAccessor;

public class ThreadCommunication {

    public static void main(String[] args) {

        Resource resource = new Resource();

        Runnable producer = new Runnable(){
            @Override
            public void run(){
                for(int i = 1; i <= 10; i++){
                    resource.produce(i);
                }    
            }
        };

        Thread producerThread = new Thread(producer);

        Thread consumerThread = new Thread(()->{
            for(int i = 1; i <= 5; i++){
                resource.consume();
            }
        });

        Thread consumerThread2 = new Thread(()->{
            for(int i = 1; i <= 5; i++){
                resource.consume2();
            }
        });

        producerThread.start();
        consumerThread.start();
        consumerThread2.start();

    }

    
        
    
}

class Resource {

        public Integer value = 0;
        public Boolean hasValue = false;

        public synchronized void consume(){
            System.out.println("Waiting to consume...");

            while(!hasValue){
            try {
                wait();
                Thread.sleep(1000); // Simulating some processing time
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }           
            }
            System.out.println("Consumed: " + value);
            hasValue = false;
            notifyAll();
        }

        public synchronized void produce(Integer value){
            System.out.println("Waiting at producer");
            while(hasValue){
                try{
                    wait();
                    Thread.sleep(1000); 
                }catch(InterruptedException e){
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            }
            this.value = value;
            hasValue = true;
            System.out.println("Produced: " + value);
            notifyAll();
        }

        public synchronized void consume2(){
            System.out.println("Waiting at consume2...");

            while(!hasValue){
            try {
                wait();
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }           
            }
            System.out.println("Consumed2: " + value);
            hasValue = false;
            notifyAll();
        }
    }