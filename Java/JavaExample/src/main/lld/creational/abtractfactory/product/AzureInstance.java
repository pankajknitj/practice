package main.lld.creational.abtractfactory.product;
//concrete product class
public class AzureInstance extends Instance{
    private Storage storage;
    public AzureInstance(int capacity) {
        super(capacity);
    }

    @Override
    public void start() {
        System.out.println("Azure instance started");
    }

    @Override
    public void stop() {
        System.out.println("Azure instance stopped");
    }

    @Override
    public void attacheStorage(Storage storage) {
        this.storage = storage;
        System.out.println("Azure instance attached to storage with id: " + storage.getId());
    }
}
