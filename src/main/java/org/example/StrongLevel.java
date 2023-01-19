package org.example;

public enum StrongLevel {
    MILD(0.5),
    NORMAL(0.75),
    STRONG(1.0);

    private double level;

    StrongLevel(double level){
        this.level = level;
    }

    public double getLevel(){
        return level;
    }
}
