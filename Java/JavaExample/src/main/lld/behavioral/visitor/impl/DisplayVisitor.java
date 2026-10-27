package main.lld.behavioral.visitor.impl;

import main.lld.behavioral.visitor.face.ShapeVisitor;
import main.lld.behavioral.visitor.model.Circle;
import main.lld.behavioral.visitor.model.Rectangle;

public class DisplayVisitor implements ShapeVisitor {
    @Override
    public void visitCircle(Circle circle) {
        System.out.println("Displaying Circle with radius: " + circle.getRadius());
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        System.out.println("Displaying Rectangle with length: " + rectangle.getLength() + " and width: " + rectangle.getWidth());
    }
}
