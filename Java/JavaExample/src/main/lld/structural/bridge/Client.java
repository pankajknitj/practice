package main.lld.structural.bridge;

import main.lld.structural.bridge.product.CentralLocking;
import main.lld.structural.bridge.product.GearLocking;
import main.lld.structural.bridge.product.Product;

public class Client {
    public static void main(String[] args) {
        Product p1 = new CentralLocking("Central Locking system");
        Product p2 = new GearLocking("Gear Locking system");

        Car bigwheel = new BigWheel(p1, "XYZ");
        Car motoren = new Motoren(p2,"MYX");

        bigwheel.produceProduct();
        bigwheel.assemble();

        motoren.produceProduct();
        motoren.assemble();
    }
}
