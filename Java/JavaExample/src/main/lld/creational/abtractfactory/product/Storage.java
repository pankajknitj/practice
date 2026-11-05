package main.lld.creational.abtractfactory.product;
//abstract product class
public abstract class Storage {
    private final int capacity;

    Storage(int capacity){
        this.capacity = capacity;
    }
    int getCapacity(){
        return capacity;
    }
    abstract int getId();
}
