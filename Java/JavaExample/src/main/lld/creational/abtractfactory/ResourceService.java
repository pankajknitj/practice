package main.lld.creational.abtractfactory;

import main.lld.creational.abtractfactory.factory.ResourceFactory;
import main.lld.creational.abtractfactory.product.Instance;
import main.lld.creational.abtractfactory.product.Storage;

//service that uses the abstract factory to provision resources
public class ResourceService {
    private final ResourceFactory resourceFactory;
    private Instance instance;

    public ResourceService(ResourceFactory resourceFactory) {
        this.resourceFactory = resourceFactory;
    }

    public void provisionInstance(int instanceCapacity, int storageCapacity) {
        instance = resourceFactory.createInstance(instanceCapacity);
        Storage storage = resourceFactory.createStorage(storageCapacity);
        instance.attacheStorage(storage);
    }

    public void startInstance() {
        instance.start();
    }
    public void stopInstance() {
        instance.stop();
    }
}
