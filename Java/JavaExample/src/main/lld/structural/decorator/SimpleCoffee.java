package main.lld.structural.decorator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SimpleCoffee implements Coffee{
    private double price;
    @Override
    public double getCost() {
        return price;
    }

    @Override
    public String getDescription() {
        return "Coffee is made up with Coffee beans";
    }
}
