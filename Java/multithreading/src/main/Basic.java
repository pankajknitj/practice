package main;

public class Basic {
    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args){
        /*Thread- 1*/
        t1 = new Thread(()->{
            for(int i = 1;i<100;i++){
                System.out.println("Thread-1: "+i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                /*Let Thread-2 finish his job first*/
                if( i == 10 ) {
                    try {
                        t2.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        /*Thread-2*/
        t2 = new Thread(()->{
            for(int i = 1;i<100;i++){
                System.out.println("Thread-2: "+i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
//        t1.setPriority(10);
        t1.start();
        t2.start();

        /*Print from Main Thread*/
        for(int i = 1;i<100;i++){
            System.out.println("Main: "+i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}