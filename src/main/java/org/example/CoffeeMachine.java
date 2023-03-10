package org.example;

public class CoffeeMachine {
    private int currentWater;
    private final int maxWater = 1000;
    private double currentCoffee;
    private final int maxCoffee = 300;
    private final int norm = 15;
    private Coffee coffee;

    public String getCurrentCoffee() {
        return String.format("Кофе осталось %.1f г", currentCoffee);
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
        if (this.coffee == null || !this.coffee.equals(coffee)) {
            this.coffee = coffee;
            currentCoffee = 0;
        }
        checkAmountCoffee(addCoffee);
    }

    private void checkAmountCoffee(double addCoffee){
        double differenceCoffee = maxCoffee - currentCoffee;
        if (addCoffee > differenceCoffee) {
            System.out.printf("Вы пытаетесь добавить слишком много кофе! Будет добавлено только %.1f г\n",
                    differenceCoffee);
            currentCoffee += differenceCoffee;
        } else {
            currentCoffee += addCoffee;
        }
    }

    public void makeCoffee(StrongLevel level, int sizeCup) {
        if (sizeCup > currentWater) {
            System.out.println("Долейте воды");
            return;
        }
        if (norm * level.getLevel() > currentCoffee) {
            System.out.println("Досыпьте кофе");
            return;
        }
        currentCoffee -= norm * level.getLevel();
        currentWater -= sizeCup;
        System.out.printf("Готовлю %s объемом %d крепость %.2f \n", coffee.getCoffeeName(), sizeCup, level.getLevel());
    }
}
