package main.lld.structural.decorator.decorate;

import main.lld.structural.decorator.Coffee;

public class MilkyCoffee extends AbstractCoffeeDecorator{
    public MilkyCoffee(Coffee coffee){
        super(coffee);
    }
    @Override
    public double getCost() {
        return 12.43 + coffee.getCost();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", milk";
    }
}
