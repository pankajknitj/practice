package main.multithreading.oc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OptimisticExamples {

    static AtomicInteger sharedCounter = new AtomicInteger(0);

    static Thread t1 = new Thread(()->{
        int counter = sharedCounter.get();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sharedCounter.incrementAndGet();
    });

    static Thread t2 = new Thread(()->{
        int counter = sharedCounter.get();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sharedCounter.set(counter + 1);
    });

    static Thread t3 = new Thread(()->{
        int counter = sharedCounter.get();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sharedCounter.set(counter + 1);
    });

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("Final Counter Value: " + sharedCounter.get());
    }
}
