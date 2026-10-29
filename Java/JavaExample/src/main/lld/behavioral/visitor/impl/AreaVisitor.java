package main.lld.behavioral.visitor.impl;

import lombok.Data;
import main.lld.behavioral.visitor.face.ShapeVisitor;
import main.lld.behavioral.visitor.model.Circle;
import main.lld.behavioral.visitor.model.Rectangle;

@Data
//Operation on element (circle, Rectangle)
public class AreaVisitor implements ShapeVisitor {
    @Override
    public void visitCircle(Circle circle) {
        double radius = circle.getRadius();
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        double length = rectangle.getLength();
        double width = rectangle.getWidth();
        double area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }
}
