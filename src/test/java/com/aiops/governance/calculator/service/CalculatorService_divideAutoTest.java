package com.aiops.governance.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorService_divideAutoTest {

    @Test
    void testMultiplyByZero() {
        CalculatorService service = new CalculatorService();
        assertThrows(IllegalArgumentException.class, () -> service.multiply(10, 0));
    }

    @Test
    void testDivideEvenlyDivisibleIntegers() {
        CalculatorService service = new CalculatorService();
        assertEquals(5.0, service.divide(10, 2).doubleValue(), 0.0001);
    }
}