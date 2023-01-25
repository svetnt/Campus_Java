package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CoffeeMachine {
    private static int count;
    private int currentWater;
    private final int maxWater = 1000;
    private double currentCoffeeBeans;
    private double currentCoffeeGround;
    private final int maxCoffee = 300;
    private final int norm = 15;
    private Coffee coffeeBeans;
    private Coffee coffeeGround;

    public CoffeeMachine() {
        count = 0;
    }

    public static String getCount() {
        return "Всего приготовлено " + count + " чашки";
    }

    public String getCurrentCoffee() {
        return String.format("Кофе в зернах осталось %.1f г.   Кофе молотого осталось %.1f г", currentCoffeeBeans,
                currentCoffeeGround);
    }

    public String getCurrentWater() {
        return String.format("Воды осталось %d мл", currentWater);
    }

    public void addWater(int addWater) {
        int differenceWater = maxWater - currentWater;
        if (addWater > differenceWater) {
            System.out.printf("Вы пытаетесь добавить слишком много воды! Будет добавлено только %d мл\n",
                    differenceWater);
            currentWater += differenceWater;
        } else {
            currentWater += addWater;
        }
    }

    public void addCoffee(double addCoffee, Coffee coffee) {
        if (coffee.getType() == Type.BEANS) {
            if (this.coffeeBeans == null || !this.coffeeBeans.equals(coffee)) {
                this.coffeeBeans = coffee;
                currentCoffeeBeans = 0;
            }
            checkAmountCoffeeBeans(addCoffee);
        } else {
            if (this.coffeeGround == null || !this.coffeeGround.equals(coffee)) {
                this.coffeeGround = coffee;
                currentCoffeeGround = 0;
            }
            checkAmountCoffeeGround(addCoffee);
        }
    }

    private void checkAmountCoffeeBeans(double addCoffee) {
        double differenceCoffee = maxCoffee - currentCoffeeBeans;
        if (addCoffee > differenceCoffee) {
            System.out.printf("Вы пытаетесь добавить слишком много кофе! Будет добавлено только %.1f г\n",
                    differenceCoffee);
            currentCoffeeBeans += differenceCoffee;
        } else {
            currentCoffeeBeans += addCoffee;
        }
    }

    private void checkAmountCoffeeGround(double addCoffee) {
        double differenceCoffee = maxCoffee - currentCoffeeGround;
        if (addCoffee > differenceCoffee) {
            System.out.printf("Вы пытаетесь добавить слишком много кофе! Будет добавлено только %.1f г\n",
                    differenceCoffee);
            currentCoffeeGround += differenceCoffee;
        } else {
            currentCoffeeGround += addCoffee;
        }
    }

    public void makeCoffee(StrongLevel level, int sizeCup, Type type) {
        if (sizeCup > currentWater) {
            System.out.println("Долейте воды");
            return;
        }
        if (type == Type.BEANS) {
            if (norm * level.getLevel() > currentCoffeeBeans) {
                System.out.println("Досыпьте кофе в контейнер для зерен");
                return;
            }
            currentCoffeeBeans -= norm * level.getLevel();
            currentWater -= sizeCup;
            count++;
            System.out.printf("Готовлю %s объемом %d крепость %.2f \n", coffeeBeans.getCoffeeName(), sizeCup, level.getLevel());
        } else {
            if (norm * level.getLevel() > currentCoffeeGround) {
                System.out.println("Досыпьте кофе в контейнер для молотого кофе");
                return;
            }
            currentCoffeeGround -= norm * level.getLevel();
            currentWater -= sizeCup;
            count++;
            System.out.printf("Готовлю %s объемом %d крепость %.2f \n", coffeeGround.getCoffeeName(), sizeCup, level.getLevel());
        }
    }
}
