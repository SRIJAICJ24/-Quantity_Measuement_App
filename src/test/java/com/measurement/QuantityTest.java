package com.measurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

    // LENGTH TESTS
    @Test
    void givenOneFootAndTwelveInches_whenCompared_shouldReturnTrue() {
        Quantity<LengthUnit> ft = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> in = new Quantity<>(12.0, LengthUnit.INCHES);
        assertEquals(ft, in);
    }

    @Test
    void givenOneFootAndOneInch_whenCompared_shouldReturnFalse() {
        Quantity<LengthUnit> ft = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> in = new Quantity<>(1.0, LengthUnit.INCHES);
        assertNotEquals(ft, in);
    }

    @Test
    void givenThreeFeetAndOneYard_whenCompared_shouldReturnTrue() {
        Quantity<LengthUnit> yd = new Quantity<>(1.0, LengthUnit.YARDS);
        Quantity<LengthUnit> ft = new Quantity<>(3.0, LengthUnit.FEET);
        assertEquals(yd, ft);
    }

    @Test
    void givenTwoInchesAndFiveCentimeters_whenCompared_shouldReturnTrue() {
        Quantity<LengthUnit> in = new Quantity<>(2.0, LengthUnit.INCHES);
        Quantity<LengthUnit> cm = new Quantity<>(5.0, LengthUnit.CENTIMETERS);
        assertEquals(in, cm);
    }

    @Test
    void givenFeet_whenConvertedToInches_shouldReturnCorrectValue() {
        Quantity<LengthUnit> ft = new Quantity<>(2.0, LengthUnit.FEET);
        double inches = ft.convertTo(LengthUnit.INCHES);
        assertEquals(24.0, inches, 0.0001);
    }

    @Test
    void givenTwoInchesAndTwoInches_whenAdded_shouldReturnFourInches() {
        Quantity<LengthUnit> q1 = new Quantity<>(2.0, LengthUnit.INCHES);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.INCHES);
        Quantity<LengthUnit> result = q1.add(q2);
        assertEquals(new Quantity<>(4.0, LengthUnit.INCHES), result);
    }

    @Test
    void givenFeetAndInches_whenAddedTargetInches_shouldReturnTotalInInches() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET); // 12 in
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.INCHES); // 2 in
        Quantity<LengthUnit> result = q1.add(q2, LengthUnit.INCHES);
        assertEquals(new Quantity<>(14.0, LengthUnit.INCHES), result);
    }

    // WEIGHT TESTS
    @Test
    void givenOneKgAndThousandGrams_whenCompared_shouldReturnTrue() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> g = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertEquals(kg, g);
    }

    // CROSS-CATEGORY TESTS
    @Test
    void givenLengthAndWeight_shouldNotCompileOrBeEqual() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        // They are completely different generics, but equals takes Object
        assertNotEquals(length, weight);
    }

    // VOLUME TESTS
    @Test
    void givenOneGallonAndLitres_whenCompared_shouldBeEqual() {
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> litres = new Quantity<>(3.78541, VolumeUnit.LITRE);
        assertEquals(gallon, litres);
    }

    // ARITHMETIC TESTS (SUBTRACT/DIVIDE)
    @Test
    void givenTwoLengths_whenSubtracted_shouldReturnCorrectDifference() {
        Quantity<LengthUnit> q1 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> result = q1.subtract(q2);
        assertEquals(new Quantity<>(1.0, LengthUnit.FEET), result);
    }

    @Test
    void givenTwoQuantities_whenDivided_shouldReturnScalar() {
        Quantity<WeightUnit> q1 = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(500.0, WeightUnit.GRAM);
        assertEquals(4.0, q1.divide(q2), 0.001);
    }
}
