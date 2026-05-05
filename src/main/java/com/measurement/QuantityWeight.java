package com.measurement;

public class QuantityWeight {
    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityWeight that = (QuantityWeight) obj;
        return Math.abs(this.unit.getBaseValue(this.value) - that.unit.getBaseValue(that.value)) < 0.0001;
    }

    public QuantityWeight add(QuantityWeight other) {
        if (other == null) throw new IllegalArgumentException("Cannot add null");
        double totalBaseValue = this.unit.getBaseValue(this.value) + other.unit.getBaseValue(other.value);
        double newValue = totalBaseValue / this.unit.getBaseValue(1.0);
        return new QuantityWeight(newValue, this.unit);
    }
}
