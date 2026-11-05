package main.lld.creational.abtractfactory.factory;

import main.lld.creational.abtractfactory.product.Instance;
import main.lld.creational.abtractfactory.product.Storage;

//abstract factory class
public interface ResourceFactory {
    Instance createInstance(int capacity);
    Storage createStorage(int capacity);
}
