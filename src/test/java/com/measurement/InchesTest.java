package com.measurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InchesTest {

    @Test
    void givenTwoEqualInches_shouldReturnTrue() {
        Inches in1 = new Inches(12.0);
        Inches in2 = new Inches(12.0);
        assertEquals(in1, in2);
    }

    @Test
    void givenFeetAndInches_whenCompared_shouldReturnFalse() {
        Feet feet = new Feet(1.0);
        Inches inches = new Inches(1.0);
        assertNotEquals(feet, inches);
    }
}
