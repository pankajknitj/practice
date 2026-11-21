package main.lld.structural.flyweight;

import lombok.AllArgsConstructor;
import main.lld.structural.flyweight.fw.TreeType;

@AllArgsConstructor
public class Tree {
    //Intrinsic state
    private TreeType type;
    //Extrinsic state
    private int x;
    private int y;
    public void plant(){
        type.plant(x,y);
    }
}
