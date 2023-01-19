package org.example;

public class Main {
    public static void main(String[] args) {
        Coffee java = new Coffee("Java", Type.GROUND);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        coffeeMachine.makeCoffee(StrongLevel.MILD.getLevel(), 150);

        coffeeMachine.addWater(1000);

        coffeeMachine.makeCoffee(StrongLevel.MILD.getLevel(), 150);

        coffeeMachine.addCoffee(250, java);

        coffeeMachine.makeCoffee(StrongLevel.MILD.getLevel(), 150);

        System.out.println(coffeeMachine.getCurrentWater());
        System.out.println(coffeeMachine.getCurrentCoffee());
    }
}