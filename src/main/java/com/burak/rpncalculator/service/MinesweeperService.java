package com.burak.rpncalculator.service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MinesweeperService {

    public List<String> calculateHints(List<String> square) {
        int m = square.size();
        int n = square.get(0).length();
        int[][] field = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (square.get(i).charAt(j) == '*') {
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ni = i + di, nj = j + dj;
                            if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                                if (di != 0 || dj != 0) {
                                    field[ni][nj]++;
                                }
                            }
                        }
                    }
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (square.get(i).charAt(j) == '*') {
                    sb.append('*');
                } else {
                    sb.append(field[i][j]);
                }
            }
            result.add(sb.toString());
        }

        return result;
    }
}