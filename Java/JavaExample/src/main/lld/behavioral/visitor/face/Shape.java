package main.lld.behavioral.visitor.face;

public interface Shape {
    void accept(ShapeVisitor visitor);
}
