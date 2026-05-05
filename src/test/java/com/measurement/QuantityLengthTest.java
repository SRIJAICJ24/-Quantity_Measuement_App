package com.measurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    @Test
    void givenOneFootAndTwelveInches_whenCompared_shouldReturnTrue() {
        QuantityLength ft = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength in = new QuantityLength(12.0, LengthUnit.INCHES);
        assertEquals(ft, in);
    }

    @Test
    void givenOneFootAndOneInch_whenCompared_shouldReturnFalse() {
        QuantityLength ft = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength in = new QuantityLength(1.0, LengthUnit.INCHES);
        assertNotEquals(ft, in);
    }

    @Test
    void givenThreeFeetAndOneYard_whenCompared_shouldReturnTrue() {
        QuantityLength yd = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength ft = new QuantityLength(3.0, LengthUnit.FEET);
        assertEquals(yd, ft);
    }

    @Test
    void givenTwoInchesAndFiveCentimeters_whenCompared_shouldReturnTrue() {
        QuantityLength in = new QuantityLength(2.0, LengthUnit.INCHES);
        QuantityLength cm = new QuantityLength(5.0, LengthUnit.CENTIMETERS);
        assertEquals(in, cm);
    }

    @Test
    void givenFeet_whenConvertedToInches_shouldReturnCorrectValue() {
        QuantityLength ft = new QuantityLength(2.0, LengthUnit.FEET);
        double inches = ft.convertTo(LengthUnit.INCHES);
        assertEquals(24.0, inches, 0.0001);
    }

    @Test
    void givenTwoInchesAndTwoInches_whenAdded_shouldReturnFourInches() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2);
        assertEquals(new QuantityLength(4.0, LengthUnit.INCHES), result);
    }
}
