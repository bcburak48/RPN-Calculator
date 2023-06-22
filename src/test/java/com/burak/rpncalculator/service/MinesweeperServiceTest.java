package com.burak.rpncalculator.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinesweeperServiceTest {

    private final MinesweeperService minesweeperService = new MinesweeperService();

    @Test
    public void testCalculateHints() {
        List<String> square = Arrays.asList("*...", "....", ".*..", "....");
        List<String> hints = minesweeperService.calculateHints(square);
        List<String> expectedHints = Arrays.asList("*100", "2210", "1*10", "1110");
        assertEquals(expectedHints, hints);
    }
}