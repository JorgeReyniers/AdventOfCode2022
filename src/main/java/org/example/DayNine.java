package org.example;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayNine implements Day {
    @Override
    public int execute(ArrayList<String> input) {
        int[][] knots = new int[10][2];
        for (int[] row: knots)
            Arrays.fill(row, 500);

        List<String> positions = new ArrayList<>();
        positions.add(500 + "," + 500);

        for (String motionCommand : input) {
            String direction = motionCommand.split(" ")[0];
            int amountOfMotions = Integer.parseInt(motionCommand.split(" ")[1]);
            for (int i = 1 ; i <= amountOfMotions ; i++) {
                switch(direction) {
                    case "R" : knots[0][0]++;
                    break;
                    case "L" : knots[0][0]--;
                    break;
                    case "U" : knots[0][1]++;
                    break;
                    case "D" : knots[0][1]--;
                    break;
                }

                for (int j = 0 ; j <= 8 ; j++) {
                    // . T T T .
                    // . T H T .
                    // . T T T .
                    // or H and T are on the same spot
                    if (Math.abs(knots[j][0] - knots[j+1][0]) <= 1 && Math.abs(knots[j][1] - knots[j+1][1]) <= 1) {
                    } else if (knots[j][1] == knots[j+1][1]) {
                        // T . H . .
                        if (knots[j][0] > knots[j+1][0]) {
                            knots[j+1][0] = knots[j][0] - 1;
                        }
                        // . . H . T
                        else {
                            knots[j+1][0] = knots[j][0] + 1;
                        }
                    } else if (knots[j][0] == knots[j+1][0]) {
                        // . . H . .
                        // . . . . .
                        // . . T . .
                        if (knots[j][1] > knots[j+1][1]) {
                            knots[j+1][1] = knots[j][1] - 1;
                        }
                        // . . T . .
                        // . . . . .
                        // . . H . .
                        else {
                            knots[j+1][1] = knots[j][1] + 1;
                        }
                    }
                    // . T . T .
                    // T . . . T
                    // . . H . .
                    // T . . . T
                    // . T . T .

                    // . . . . .
                    // T . . . .
                    // . . H . .
                    // T . . . .
                    // . . . . .
                    else if (knots[j][0] - knots[j+1][0] >= 2) {
                        knots[j+1][1] = knots[j][1];
                        knots[j+1][0] = knots[j][0] - 1;
                    }

                    // . . . . .
                    // . . . . T
                    // . . H . .
                    // . . . . T
                    // . . . . .
                    else if (knots[j][0] - knots[j+1][0] <= -2) {
                        knots[j+1][1] = knots[j][1];
                        knots[j+1][0] = knots[j][0] + 1;
                    }

                    // . . . . .
                    // . . . . .
                    // . . H . .
                    // . . . . .
                    // . T . T .
                    else if (knots[j][1] - knots[j+1][1] >= 2) {
                        knots[j+1][0] = knots[j][0];
                        knots[j+1][1] = knots[j][1] - 1;
                    }

                    // . T . T .
                    // . . . . .
                    // . . H . .
                    // . . . . .
                    // . . . . .
                    else if (knots[j][1] - knots[j+1][1] <= -2) {
                        knots[j+1][0] = knots[j][0];
                        knots[j+1][1] = knots[j][1] + 1;
                    }
                }

                if (!positions.contains(knots[9][0] + "," + knots[9][1])) {
                    positions.add(knots[9][0] + "," + knots[9][1]);
                }
            }
        }
        return positions.size();
    }
}
