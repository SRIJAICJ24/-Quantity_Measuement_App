package com.measurement;

public enum Operation {
    ADD {
        @Override
        public double execute(double a, double b) { return a + b; }
    },
    SUBTRACT {
        @Override
        public double execute(double a, double b) { return a - b; }
    };

    public abstract double execute(double a, double b);
}
