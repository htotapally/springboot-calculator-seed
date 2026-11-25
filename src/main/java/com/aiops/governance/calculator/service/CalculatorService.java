package com.aiops.governance.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Number add(Number a, Number b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Both parameters must not be null.");
        }
        
        if (!(a instanceof Integer && b instanceof Integer)) {
            return a.doubleValue() + b.doubleValue();
        }
        
        return a.intValue() + b.intValue();
    }

    public Number subtract(Number a, Number b) {
        if (a instanceof Integer && b instanceof Integer) {
            return a.intValue() - b.intValue();
        }
        return a.doubleValue() - b.doubleValue();
    }

    public Number multiply(Number a, Number b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Both arguments must not be null.");
        }
        
        if (a instanceof Integer && b instanceof Integer) {
            int intValueA = a.intValue();
            int intValueB = b.intValue();
            
            if (intValueB == 0) {
                throw new IllegalArgumentException("Division by zero is not allowed.");
            }
            
            return intValueA * intValueB;
        }
        
        double doubleValueA = a.doubleValue();
        double doubleValueB = b.doubleValue();
        
        if (doubleValueB == 0.0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        
        return doubleValueA * doubleValueB;
    }

    public Number divide(Number a, Number b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        if (b.doubleValue() == 0.0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a instanceof Integer && b instanceof Integer ? 
                a.intValue() / b.intValue() : 
                a.doubleValue() / b.doubleValue();
    }
}
