package main.lld.creational.abtractfactory.product;

//abstract Product class
public abstract class Instance {
    private final int capacity;
    Instance(int capacity){
        this.capacity = capacity;
    }
    int getCapacity(){
        return capacity;
    }
    public abstract void start();
    public abstract void stop();
    public abstract void attacheStorage(Storage storage);
}
