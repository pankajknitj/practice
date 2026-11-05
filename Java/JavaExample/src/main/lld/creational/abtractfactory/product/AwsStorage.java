package main.lld.creational.abtractfactory.product;
//concrete product class
public class AwsStorage extends Storage{
    private final int id;
    public AwsStorage(int capacity) {
        super(capacity);
        id = (int) (Math.random() * 1000);
    }

    @Override
    int getId() {
        return id;
    }
}
