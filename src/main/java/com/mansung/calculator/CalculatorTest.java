package com.mansung.calculator;

import org.junit.Test;


public class CalculatorTest {
    private Calculator calculator = new Calculator();
    
    @Test 
    public void testSum() {
        assertEqauls(5, calculator.sum(2,3));
       
    }

    
}
