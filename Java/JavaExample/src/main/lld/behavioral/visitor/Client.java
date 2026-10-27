package main.lld.behavioral.visitor;

import main.lld.behavioral.visitor.face.Shape;
import main.lld.behavioral.visitor.impl.AreaVisitor;
import main.lld.behavioral.visitor.impl.DisplayVisitor;
import main.lld.behavioral.visitor.model.Circle;
import main.lld.behavioral.visitor.model.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        Shape c1 = new Circle(4.55);
        Shape c2 = new Circle(5.55);
        Shape r1 = new Rectangle(23,233.2);
        Shape r2 = new Rectangle(23,233.2);

        List<Shape> shapes = new ArrayList<>(List.of(c1, c2, r1, r2));

        shapes.forEach(shape -> shape.accept(new AreaVisitor()));

        shapes.forEach(shape -> shape.accept(new DisplayVisitor()));

    }
}
