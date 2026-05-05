package com.measurement;

public enum LengthUnit {
    FEET(12.0),
    INCHES(1.0);

    private final double baseConversion;

    LengthUnit(double baseConversion) {
        this.baseConversion = baseConversion;
    }

    public double getBaseValue(double value) {
        return value * baseConversion;
    }
}
