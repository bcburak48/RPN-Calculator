package com.burak.rpncalculator.controller;

import com.burak.rpncalculator.model.CalculateRequest;
import com.burak.rpncalculator.model.CalculateResponse;
import com.burak.rpncalculator.service.RpnCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final RpnCalculatorService calculatorService;

    @Autowired
    public CalculatorController(RpnCalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    public CalculateResponse calculate(@RequestBody CalculateRequest request) {
        double result = calculatorService.calculate(request.getExpression());
        CalculateResponse response = new CalculateResponse();
        response.setResult(result);
        return response;
    }
}