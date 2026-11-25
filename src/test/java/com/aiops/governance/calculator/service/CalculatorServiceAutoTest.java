package com.aiops.governance.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CalculatorServiceAutoTest {

    @Test
    public void testDivideWithNullInput() {
        CalculatorService service = new CalculatorService();
        assertThrows(IllegalArgumentException.class, () -> service.divide(null, 1));
    }

    @Test
    public void testDivideByZero() {
        CalculatorService service = new CalculatorService();
        assertThrows(ArithmeticException.class, () -> service.divide(10, 0));
    }

    @Test
    public void testDivideWithValidInput() {
        CalculatorService service = new CalculatorService();
        assertEquals(5.0, service.divide(10, 2), "Expected division result to be 5.0");
    }
}