package com.measurement;

public class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityLength that = (QuantityLength) obj;
        return Math.abs(this.unit.getBaseValue(this.value) - that.unit.getBaseValue(that.value)) < 0.0001;
    }

    public double convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) throw new NullPointerException("Target unit cannot be null");
        double baseValue = this.unit.getBaseValue(this.value);
        return baseValue / targetUnit.getBaseValue(1.0);
    }

    public QuantityLength add(QuantityLength other) {
        if (other == null) throw new IllegalArgumentException("Cannot add null");
        double totalBaseValue = this.unit.getBaseValue(this.value) + other.unit.getBaseValue(other.value);
        double newValue = totalBaseValue / this.unit.getBaseValue(1.0);
        return new QuantityLength(newValue, this.unit);
    }
}
