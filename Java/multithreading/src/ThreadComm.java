import java.util.LinkedList;
import java.util.Queue;

public class ThreadComm {
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        System.out.println("starting communication");
        Thread producer = new Thread(()->{
            for(int i =0;i<20;i++){
                synchronized (q){
                    System.out.println("produced: "+i);
                    q.offer(i);
//                    System.out.println("notifying");
                    q.notifyAll();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }


        });

        Thread consumer = new Thread(()->{
            synchronized (q){
                while (true){
                    if(q.isEmpty()){
                        try {
                            System.out.println("waiting for values");
                            q.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("consumed: "+q.poll());
//                    q.notifyAll();
                }
            }
        });
        consumer.start();
        producer.start();
    }
}
