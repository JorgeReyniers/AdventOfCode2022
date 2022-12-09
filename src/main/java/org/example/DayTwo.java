package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class DayTwo implements Day {
    public DayTwo() {
    }

    public int execute(ArrayList<String> inputDayTwo) {
        int totalScore = 0;
        for(String round: inputDayTwo) {
            String gameResult = round.split(" ")[1];
            totalScore += calculateGameScore(gameResult);
            totalScore += calculateMoveScore(round);
        }
        return totalScore;
    }

    @Override
    public String executeWithStringOutput(ArrayList<String> input) {
        return null;
    }

    private int calculateGameScore(String gameResult) {
        return Arrays.asList("X", "Y", "Z").indexOf(gameResult) * 3;
    }

    private int calculateMoveScore(String round) {
        if (rock(round)) {
            return 1;
        } else if (paper(round)) {
            return 2;
        } else {
            return 3;
        }
    }

    private boolean rock(String round) {
        return Arrays.asList("A Y", "B X", "C Z").contains(round);
    }

    private boolean paper(String round) {
        return Arrays.asList("A Z", "B Y", "C X").contains(round);
    }
}
