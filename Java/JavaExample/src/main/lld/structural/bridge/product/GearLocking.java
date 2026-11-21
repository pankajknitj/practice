package main.lld.structural.bridge.product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GearLocking implements Product {
    private String productName;

    @Override
    public String productName() {
        return productName;
    }

    @Override
    public void produce() {
        System.out.println("Producing gear locking system");
    }
}
