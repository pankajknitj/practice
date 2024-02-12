public class DeadLock {

    static class A{
        synchronized void test(B b) throws InterruptedException {
            System.out.println("inside a");
            Thread.sleep(1000);
            System.out.println("calling B");
            b.test(null);
        }
    }

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
        //deadlock 1
        Thread t1 = new Thread(()->{
            try {
                a.test(b);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        b.test(a);

        //deadlock 2
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


        //deadlock 3
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
