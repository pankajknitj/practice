package main.lld.behavioral.visitor.face;

import main.lld.behavioral.visitor.model.Circle;
import main.lld.behavioral.visitor.model.Rectangle;

public interface ShapeVisitor {
    void visitCircle(Circle circle);
    void visitRectangle(Rectangle rectangle);
}
