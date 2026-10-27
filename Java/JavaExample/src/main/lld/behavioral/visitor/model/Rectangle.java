package main.lld.behavioral.visitor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.lld.behavioral.visitor.face.Shape;
import main.lld.behavioral.visitor.face.ShapeVisitor;

@Data
@AllArgsConstructor
public class Rectangle implements Shape {
    private double length;
    private double width;

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitRectangle(this);
    }
}
