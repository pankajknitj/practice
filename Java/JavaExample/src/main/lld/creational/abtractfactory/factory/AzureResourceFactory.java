package main.lld.creational.abtractfactory.factory;

import main.lld.creational.abtractfactory.product.*;
//concrete factory class
public class AzureResourceFactory implements ResourceFactory{
    @Override
    public Instance createInstance(int capacity) {
        return new AzureInstance(capacity);
    }

    @Override
    public Storage createStorage(int capacity) {
        return new AzureStorage(capacity);
    }
}
