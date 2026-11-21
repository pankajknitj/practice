package main.lld.structural.decorator;

import main.lld.structural.decorator.decorate.CreamyCoffee;
import main.lld.structural.decorator.decorate.MilkyCoffee;

public class Client {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee(69.76);
        //adding milk
        coffee = new MilkyCoffee(coffee);
        //adding cream
        coffee = new CreamyCoffee(coffee);

        System.out.println(coffee.getDescription());
        System.out.println(coffee.getCost());
    }
}
