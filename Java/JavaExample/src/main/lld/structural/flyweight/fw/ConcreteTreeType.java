package main.lld.structural.flyweight.fw;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConcreteTreeType implements TreeType {
    private String name;
    private String color;
    private String texture;

    @Override
    public void plant(int x, int y) {
        System.out.printf("Planting tree at %s,%s, name: %s, color: %s, texture: %s%n", x,y,name,color,texture);
    }
}
