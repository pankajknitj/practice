package main.lld.creational.abtractfactory.product;
//concrete product class
public class AwsInstance extends Instance{
    private Storage storage;

    public AwsInstance(int capacity) {
        super(capacity);
    }

    @Override
    public void start() {
        System.out.println("Aws instance started");
    }

    @Override
    public void stop() {
        System.out.println("Aws instance stopped");
    }

    @Override
    public void attacheStorage(Storage storage) {
        this.storage = storage;
        System.out.println("Aws instance attached to storage with id: " + storage.getId());
    }
}
