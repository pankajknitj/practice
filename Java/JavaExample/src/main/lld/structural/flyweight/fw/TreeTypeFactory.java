package main.lld.structural.flyweight.fw;

import java.util.HashMap;
import java.util.Map;

public class TreeTypeFactory {
    Map<String, TreeType> cache = new HashMap<>();

    public TreeType getTreeType(String name, String color, String texture){
        String key = name + color + texture;
        if(!cache.containsKey(key)){
            cache.put(key, new ConcreteTreeType(name,color, texture));
        }
        return cache.get(key);
    }
    public int getCount(){
        return cache.size();
    }
}
