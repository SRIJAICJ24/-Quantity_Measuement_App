package com.measurement;

public class Quantity<U extends IMeasurable> {
    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Quantity<?> that = (Quantity<?>) obj;

        if (!this.unit.getClass().equals(that.unit.getClass())) return false;

        double val1 = this.unit.getBaseValue(this.value);
        double val2 = ((IMeasurable) that.unit).getBaseValue(that.value);

        return Math.abs(val1 - val2) < 0.0001;
    }

    public double convertTo(U targetUnit) {
        if (targetUnit == null) throw new NullPointerException("Target unit cannot be null");
        double baseValue = this.unit.getBaseValue(this.value);
        return baseValue / targetUnit.getBaseValue(1.0);
    }

    private Quantity<U> performOperation(Quantity<U> other, Operation op) {
        if (other == null) throw new IllegalArgumentException("Operand cannot be null");
        double v1 = this.unit.getBaseValue(this.value);
        double v2 = other.unit.getBaseValue(other.value);
        double resultBase = op.execute(v1, v2);
        double newValue = resultBase / this.unit.getBaseValue(1.0);
        return new Quantity<>(newValue, this.unit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return performOperation(other, Operation.ADD);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        if (other == null || targetUnit == null) throw new IllegalArgumentException("Arguments cannot be null");
        double v1 = this.unit.getBaseValue(this.value);
        double v2 = other.unit.getBaseValue(other.value);
        double resultBase = Operation.ADD.execute(v1, v2);
        double newValue = resultBase / targetUnit.getBaseValue(1.0);
        return new Quantity<>(newValue, targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return performOperation(other, Operation.SUBTRACT);
    }

    public double divide(Quantity<U> other) {
        if (other == null) throw new IllegalArgumentException("Cannot divide by null");
        double denominator = other.unit.getBaseValue(other.value);
        if (denominator == 0) throw new ArithmeticException("Division by zero");
        return this.unit.getBaseValue(this.value) / denominator;
    }
}
