package com.example.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void testAdd() {
        assertEquals(5.0, add(2,3));
    }

    @Test
    public void testDivByZero() {
        assertThrows(ArithmeticException.class, () -> divide(1,0));
    }

    // simple helpers used only in unit tests
    double add(double a, double b) { return a + b; }
    double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("div by zero");
        return a / b;
    }
}
