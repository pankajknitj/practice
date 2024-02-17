package main.multithreading;

import java.util.LinkedList;
import java.util.Queue;

/*Keywords:
* 1. wait()
* 2. notify()
* 3. notifyAll()
*
* Before executing this methods thread should have lock on that obj, else get IllegalMonitorException*/
public class ThreadCommunication {
    /*Common Object*/
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        System.out.println("starting communication");
        /*Producer which produces a integer every 2 sec*/
        Thread producer = new Thread(()->{
            for(int i =0;i<20;i++){
                /*Acquiring lock
                * After producing it will notify other thread to consume this*/
                synchronized (q){
                    System.out.println("produced: "+i);
                    q.offer(i);
                    q.notifyAll();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        /*Consumer Thread*/
        Thread consumer = new Thread(()->{
            /*Acquiring lock*/
            synchronized (q){
                /*Infinitely running loop*/
                while (true){
                    /*if Empty then wait untill it get notify*/
                    if(q.isEmpty()){
                        try {
                            System.out.println("waiting for values");
                            q.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    /* else consume value*/
                    System.out.println("consumed: "+q.poll());
                }
            }
        });
        consumer.start();
        producer.start();
    }
}
