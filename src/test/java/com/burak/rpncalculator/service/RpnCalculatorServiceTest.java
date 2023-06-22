package com.burak.rpncalculator.service;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RpnCalculatorServiceTest {

    private final RpnCalculatorService calculatorService = new RpnCalculatorService();

    @Test
    public void testCalculate() {
        double result = calculatorService.calculate("5 3 +");
        assertEquals(8, result);
    }
}