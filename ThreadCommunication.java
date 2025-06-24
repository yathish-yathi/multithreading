public class ThreadCommunication {

    public static void main(String[] args) {

        Resource resource = new Resource();

        Runnable producer = new Runnable(){
            @Override
            public void run(){
                for(int i = 1; i < 5; i++){
                    resource.produce(i);
                }    
            }
        };

        Thread producerThread = new Thread(producer);

        Thread consumerThread = new Thread(()->{
            for(int i = 1; i < 5; i++){
                resource.consume();
            }
        });

        producerThread.start();
        consumerThread.start();


    }

    
        
    
}

class Resource {

        public Integer value = 0;
        public Boolean hasValue = false;

        public synchronized void consume(){
            //System.out.println("Waiting to consume...");

            while(!hasValue){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }           
            }
            System.out.println("Consumed: " + value);
            hasValue = false;
            notify();
        }

        public synchronized void produce(Integer value){
            //System.out.println("Producing: " + value);
            while(hasValue){
                try{
                    wait();
                }catch(InterruptedException e){
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            }
            this.value = value;
            hasValue = true;
            System.out.println("Produced: " + value);
            notify();
        }
    }