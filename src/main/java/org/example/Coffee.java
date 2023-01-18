package org.example;

public class Coffee {
    private String name;
    private Type type;

    public Coffee(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getCoffeeName() {
        return name + " " + type.getCoffeeDescription();
    }
}
