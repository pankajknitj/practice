package main.lld.behavioral.visitor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.lld.behavioral.visitor.face.Shape;
import main.lld.behavioral.visitor.face.ShapeVisitor;

@Data
@AllArgsConstructor
//Concrete Element
public class Circle implements Shape {
    private double radius;

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitCircle(this);
    }
}
