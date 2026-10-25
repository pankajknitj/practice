package main.reflection;

import java.util.List;

public class Animal {
    public FlyData getFlyData(Class<?> clazz) {
        if (canFly(clazz)) {
            Flyable flyable = clazz.getAnnotation(Flyable.class);
            FlyData flyData = new FlyData();
            flyData.maxSpeed = flyable.maxSpeed();
            flyData.maxAltitude = flyable.maxAltitude();
            return flyData;
        }
        return null;

    }

    private boolean canFly(Class<?> clazz) {
        return clazz.isAnnotationPresent(Flyable.class);
    }
}
