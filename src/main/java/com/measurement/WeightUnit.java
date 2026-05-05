package com.measurement;

public enum WeightUnit {
    GRAM(1.0),
    KILOGRAM(1000.0),
    POUND(453.592);

    private final double baseConversion;

    WeightUnit(double baseConversion) {
        this.baseConversion = baseConversion;
    }

    public double getBaseValue(double value) {
        return value * baseConversion;
    }
}
