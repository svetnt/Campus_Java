package org.example;

import java.util.Objects;

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

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return name.equals(coffee.name) && type == coffee.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
