package com.burak.rpncalculator.service;


import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class RpnCalculatorService {

    public double calculate(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    double subtractor = stack.pop();
                    stack.push(stack.pop() - subtractor);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    double divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                default:
                    stack.push(Double.valueOf(token));
            }
        }

        return stack.pop();
    }
}