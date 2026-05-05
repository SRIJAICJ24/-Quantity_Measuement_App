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
}
