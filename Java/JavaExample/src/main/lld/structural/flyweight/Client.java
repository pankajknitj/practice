package main.lld.structural.flyweight;

import main.lld.structural.flyweight.fw.TreeTypeFactory;

public class Client {
    public static void main(String[] args) {
        TreeTypeFactory factory = new TreeTypeFactory();
        Forest forest = new Forest(factory);

        forest.addTree("T1","Red","light", 0,0);
        forest.addTree("T1","Red","light", 0,1);
        forest.addTree("T1","Red","light", 0,2);

        forest.addTree("T2","Green","light", 0,3);
        forest.addTree("T2","Green","light", 0,4);
        forest.addTree("T2","Green","light", 0,5);

        System.out.println(factory.getCount());
        forest.makeForest();
    }
}
