package main.lld.structural.decorator.decorate;

import main.lld.structural.decorator.Coffee;

public class CreamyCoffee extends AbstractCoffeeDecorator{
    public CreamyCoffee(Coffee coffee){
        super(coffee);
    }
    @Override
    public double getCost() {
        return 10 + coffee.getCost();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Cream";
    }
}
