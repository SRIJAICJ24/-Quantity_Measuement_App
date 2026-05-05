package com.measurement;

public enum LengthUnit implements IMeasurable {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.4);

    private final double baseConversion;

    LengthUnit(double baseConversion) {
        this.baseConversion = baseConversion;
    }

    @Override
    public double getBaseValue(double value) {
        return value * baseConversion;
    }
}
