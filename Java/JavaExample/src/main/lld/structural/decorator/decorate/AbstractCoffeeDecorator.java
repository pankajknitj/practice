package main.lld.structural.decorator.decorate;

import main.lld.structural.decorator.Coffee;

public abstract class AbstractCoffeeDecorator implements Coffee {
    Coffee coffee;

    public AbstractCoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }
}
