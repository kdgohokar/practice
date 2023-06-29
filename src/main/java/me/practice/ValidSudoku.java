package me.practice;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static boolean isValid(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Character number = board[i][j];
                if (number != '.') {
                    if (!seen.add("Number " + number + " seen at row " + i) ||
                        !seen.add("Number " + number + " seen at column " + j) ||
                        !seen.add("Number " + number + " seen at block " + i/3 +"-"+ j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
