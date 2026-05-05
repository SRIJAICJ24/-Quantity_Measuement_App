package com.measurement;

public enum WeightUnit implements IMeasurable {
    GRAM(1.0),
    KILOGRAM(1000.0),
    POUND(453.592);

    private final double baseConversion;

    WeightUnit(double baseConversion) {
        this.baseConversion = baseConversion;
    }

    @Override
    public double getBaseValue(double value) {
        return value * baseConversion;
    }
}
