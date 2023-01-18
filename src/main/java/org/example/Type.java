package org.example;

public enum Type {
    GROUND("молотый"),
    BEANS("в зернах");

    private String description;

    private Type(String description) {
        this.description = description;
    }

    public String getCoffeeDescription() {
        return description;
    }
}
