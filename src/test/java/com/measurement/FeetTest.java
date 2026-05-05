package com.measurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FeetTest {

    @Test
    void givenZeroFeet_whenComparedWithZeroFeet_shouldReturnTrue() {
        Feet feet1 = new Feet(0.0);
        Feet feet2 = new Feet(0.0);
        assertEquals(feet1, feet2);
    }

    @Test
    void givenTwoDifferentFeet_whenCompared_shouldReturnFalse() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(2.0);
        assertNotEquals(feet1, feet2);
    }

    @Test
    void givenNull_whenCompared_shouldReturnFalse() {
        Feet feet = new Feet(1.0);
        assertNotEquals(feet, null);
    }

    @Test
    void givenDifferentObjectType_whenCompared_shouldReturnFalse() {
        Feet feet = new Feet(1.0);
        assertNotEquals(feet, new Object());
    }
}
