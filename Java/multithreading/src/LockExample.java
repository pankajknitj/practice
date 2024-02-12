import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

   static class Counter{
       private ReentrantLock l = new ReentrantLock();
       int count =0;
       void setValue(int c) {
           System.out.println(Thread.currentThread().getName()+" wants lock");
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

        Thread t1 = new Thread(()->{
            c.setValue(12);
        });
        Thread t2 = new Thread(()->{
            c.setValue(12);
        });
        t1.start();
        t2.start();
    }
}
