package main.lld.structural.flyweight;

import main.lld.structural.flyweight.fw.TreeType;
import main.lld.structural.flyweight.fw.TreeTypeFactory;

import java.util.ArrayList;
import java.util.List;

public class Forest {
    private final TreeTypeFactory factory;
    private final List<Tree> trees = new ArrayList<>();

    public Forest(TreeTypeFactory factory){
        this.factory = factory;
    }

    public void addTree(String name, String color, String texture, int x, int y){
        TreeType type = factory.getTreeType(name, color,texture);
        trees.add(new Tree(type,x,y));
    }
    public void makeForest(){
        trees.forEach(Tree::plant);
    }
}
