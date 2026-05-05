package com.measurement;

public enum VolumeUnit implements IMeasurable {
    LITRE(1000.0),
    MILLILITRE(1.0),
    GALLON(3785.41);

    private final double baseConversion;

    VolumeUnit(double baseConversion) {
        this.baseConversion = baseConversion;
    }

    @Override
    public double getBaseValue(double value) {
        return value * baseConversion;
    }
}
