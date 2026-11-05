package main.lld.creational.abtractfactory;

import main.lld.creational.abtractfactory.factory.AwsResourceFactory;
import main.lld.creational.abtractfactory.factory.AzureResourceFactory;
import main.lld.creational.abtractfactory.factory.ResourceFactory;
import main.lld.creational.abtractfactory.product.Instance;
import main.lld.creational.abtractfactory.product.Storage;

public class Client {
    public static void main(String[] args) {
        //configuring AWS
        ResourceService resourceService = new ResourceService(new AwsResourceFactory());
        resourceService.provisionInstance(4, 100);
        resourceService.startInstance();

        //configuring Azure
        resourceService = new ResourceService(new AzureResourceFactory());
        resourceService.provisionInstance(8, 200);
        resourceService.startInstance();
    }
}
