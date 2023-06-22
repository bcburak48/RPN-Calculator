package com.burak.rpncalculator.controller;

import com.burak.rpncalculator.model.ShowHintsRequest;
import com.burak.rpncalculator.model.ShowHintsResponse;
import com.burak.rpncalculator.service.MinesweeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MinesweeperController {

    private final MinesweeperService minesweeperService;

    @Autowired
    public MinesweeperController(MinesweeperService minesweeperService) {
        this.minesweeperService = minesweeperService;
    }

    @PostMapping("/show-hints")
    public ShowHintsResponse showHints(@RequestBody ShowHintsRequest request) {
        List<String> hints = minesweeperService.calculateHints(request.getSquare());
        ShowHintsResponse response = new ShowHintsResponse();
        response.setHints(hints);
        return response;
    }
}