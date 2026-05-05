package com.measurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LengthUnitTest {

    @Test
    void testLengthUnitConversion() {
        assertEquals(12.0, LengthUnit.FEET.getBaseValue(1.0), 0.0001);
        assertEquals(0.4, LengthUnit.CENTIMETERS.getBaseValue(1.0), 0.0001);
        assertEquals(1.0, LengthUnit.INCHES.getBaseValue(1.0), 0.0001);
        assertEquals(36.0, LengthUnit.YARDS.getBaseValue(1.0), 0.0001);
    }
}
