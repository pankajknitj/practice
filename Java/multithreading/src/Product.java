public class Product {
    private int price;

    public Product(int p){
        price = p;
    }
    synchronized void setPrice(int p) {
        System.out.println(Thread.currentThread().getName());
        price = p;
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("price set");

        synchronized (this){

        }
    }
}
