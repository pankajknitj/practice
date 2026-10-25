package main.reflection;

public class Main {
    public static void main(String[] args) {
        Animal horse = new Horse();
        FlyData flyData = horse.getFlyData(Horse.class);
        if (flyData != null) {
            System.out.println("Horse can fly with max speed: " + flyData.maxSpeed + " and max altitude: " + flyData.maxAltitude);
        } else {
            System.out.println("Horse cannot fly.");
        }
    }
}
