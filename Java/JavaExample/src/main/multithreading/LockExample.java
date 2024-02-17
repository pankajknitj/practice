package main.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* Example of new Lock in java, to overcome the flaws of synchronized keyword*/
public class LockExample {

    /* Class which maintains count and count will be changed only when thread acquire lock*/
   static class Counter{
       private Lock l = new ReentrantLock();
       int count =0;
       void setValue(int c) {
           System.out.println(Thread.currentThread().getName()+" wants lock");
           /* if lock acquired the do this else do else part*/
           if(l.tryLock()){
               System.out.println("lock granted");
               count = c;
               System.out.println("value changed by "+Thread.currentThread().getName());
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               l.unlock();
           }
           else System.out.println("lock not granted");

       }
   }

    public static void main(String[] args) {
        Counter c = new Counter();
        /* Thread-1*/
        Thread t1 = new Thread(()->{
            c.setValue(12);
        });
        /* Thread-2*/
        Thread t2 = new Thread(()->{
            c.setValue(12);
        });

        t1.start();
        t2.start();
    }
}
