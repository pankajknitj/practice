package main.lld.creational.abtractfactory.product;
//concrete product class
public class AzureStorage extends Storage{
    private final int id;
    public AzureStorage(int capacity) {
        super(capacity);
        id = (int) (Math.random() * 1000);
    }

    @Override
    int getId() {
        return id;
    }
}
