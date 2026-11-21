package main.lld.structural.bridge;

import main.lld.structural.bridge.product.Product;

public abstract class Car {
    protected Product product;
    protected String model;

    Car(Product product, String model){
        this.product = product;
        this.model = model;
    }

    public abstract void assemble();
    public abstract void  produceProduct();

    public void printDetails(){
        System.out.println("Car model: " + model + "Assembled with " + product.productName());
    }
}
