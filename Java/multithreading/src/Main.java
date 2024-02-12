public class Main {
    static Thread t1 = null;
    static Thread t2 = null;

    static Product p = null;
    public static void main(String[] args){
        p = new Product(100);
        t1 = new Thread(()->{
            System.out.println("inside child thread1");
//            for(int i = 1;i<100;i++){
//                System.out.println(" c1"+i);
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }

//                if( i == 10 ) {
//                    try {
//                        t2.join();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
            System.out.println("setting product price");
            p.setPrice(150);
        });
        t2 = new Thread(()->{
//            System.out.println("inside child thread2");
//            for(int i = 1;i<100;i++){
//                System.out.println(" c2"+i);
//
//            }
            //deadlock
//            try {
//                t1.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println("setting product price");
            p.setPrice(150);
        });
//        t1.setPriority(10);
        t1.start();
        t2.start();

//        System.out.println("inside main thread ");
//        for(int i = 1;i<100;i++){
//            System.out.println(" main");
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }

    }
}