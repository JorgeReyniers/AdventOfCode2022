package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class DayTwo {
    public DayTwo() {
    }

    public int execute(ArrayList<String> inputDayTwo) {
        int totalScore = 0;
        for(String round: inputDayTwo) {
            String myMove = round.split(" ")[1];
            totalScore += calculateGameScore(round);
            totalScore += calculateMoveScore(myMove);
        }
        return totalScore;
    }

    private int calculateMoveScore(String myMove) {
        return Arrays.asList("X", "Y", "Z").indexOf(myMove) + 1;
    }

    private int calculateGameScore(String round) {
        if (iWin(round)) {
            return 6;
        } else if (draw(round)) {
            return 3;
        } else {
            return 0;
        }
    }

    private boolean iWin(String round) {
        return Arrays.asList("A Y", "B Z", "C X").contains(round);
    }

    private boolean draw(String round) {
        return Arrays.asList("A X", "B Y", "C Z").contains(round);
    }
}
