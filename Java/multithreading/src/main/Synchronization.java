package main;

public class Synchronization {
    public static void main(String[] args) {
        /*Initialization*/
        Product p = new Product(100);
        Thread t1;
        Thread t2;
        /*Thread-1*/
        t1 = new Thread(()->{
            p.setPrice(150);
        });

        /*Thread-2*/
        t2 = new Thread(()->{
            p.setPrice(150);
        });

        t1.start();
        t2.start();

    }
    /* A class have synchronized method which can be accessible by only one thread at a time*/
    static class Product {
        private int price;

        public Product(int p) {
            price = p;
        }
        /*Synchronized method*/
        synchronized void setPrice(int p) {
            System.out.println(Thread.currentThread().getName() + " trying to set price");
            price = p;
            try {
                Thread.currentThread().sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("price set");

        }
    }
}
