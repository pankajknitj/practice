package main.lld.structural.bridge;

import main.lld.structural.bridge.product.Product;

public class BigWheel extends Car{
    public BigWheel(Product product, String model){
        super(product,model);
    }
    @Override
    public void assemble() {
        System.out.println("Assembling " + model + " with " + product.productName() );
    }

    @Override
    public void produceProduct() {
        System.out.println("Producing for " + model);
        product.produce();
    }
}
