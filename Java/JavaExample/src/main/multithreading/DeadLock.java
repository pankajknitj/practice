package main.multithreading;

public class DeadLock {

    /* Inside test calling B.test()*/
    static class A{
        synchronized void test(B b) throws InterruptedException {
            System.out.println("inside a");
            Thread.sleep(1000);
            System.out.println("calling B");
            b.test(null);
        }
    }
    /* Inside test calling A.test()*/
    static class B{
        synchronized  void test(A a) throws InterruptedException {
            System.out.println("inside B");
            Thread.sleep(1000);
            System.out.println("calling A");
            a.test(null);
        }
    }

    static A a = new A();
    static B b = new B();

    static Thread t1;
    static Thread t2;
    public static void main(String[] args) throws InterruptedException {
        /*Deadlock 1
        * Internally trying to acquire lock on Object b, but b is already locked by main thread
        * due to line b.test(a)*/
        Thread t1 = new Thread(()->{
            try {
                a.test(b);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        /*internally trying to acquire lock on object a, but lock is acquired by  Thread-1*/
        b.test(a);

        /*Deadlock 2
        * Both Thread join each other*/
//        t1 = new Thread(()->{
//            try {
//                t2.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        t2 = new Thread(()->{
//            try {
//                t1.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        t1.start();
//        t2.start();


        /*Deadlock 3
        * Thread join itself*/
//        t1 = new Thread(()->{
//            try {
//                t1.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        t1.start();
    }
}
