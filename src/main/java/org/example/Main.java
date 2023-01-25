package org.example;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Coffee java = new Coffee("Java", Type.GROUND);
        Coffee buchido = new Coffee("Buchido", Type.BEANS);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        coffeeMachine.makeCoffee(StrongLevel.NORMAL, 150, Type.BEANS);

        coffeeMachine.addWater(1000);

        coffeeMachine.makeCoffee(StrongLevel.NORMAL, 150, Type.BEANS);

        coffeeMachine.addCoffee(12, java);

        coffeeMachine.makeCoffee(StrongLevel.NORMAL, 150, Type.BEANS);

        System.out.println(coffeeMachine.getCurrentWater());
        System.out.println(coffeeMachine.getCurrentCoffee());

        coffeeMachine.makeCoffee(StrongLevel.NORMAL, 150, Type.BEANS);

        coffeeMachine.addCoffee(100, buchido);

        coffeeMachine.makeCoffee(StrongLevel.NORMAL, 150, Type.BEANS);

        coffeeMachine.makeCoffee(StrongLevel.MILD, 150, Type.GROUND);

        System.out.println(coffeeMachine.getCurrentWater());
        System.out.println(coffeeMachine.getCurrentCoffee());
        System.out.println(CoffeeMachine.getCount());

    }
}