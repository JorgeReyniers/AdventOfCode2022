package org.example;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DayNine implements Day {
    @Override
    public int execute(ArrayList<String> input) {
        int positionHeadX = 500;
        int positionHeadY = 500;
        int positionTailX = 500;
        int positionTailY = 500;
        List<String> positions = new ArrayList<>();
        positions.add(positionTailX + "," + positionTailY);
        for (String motionCommand : input) {
            String direction = motionCommand.split(" ")[0];
            int amountOfMotions = Integer.parseInt(motionCommand.split(" ")[1]);
            for (int i = 1 ; i <= amountOfMotions ; i++) {
                switch(direction) {
                    case "R" : positionHeadX++;
                    break;
                    case "L" : positionHeadX--;
                    break;
                    case "U" : positionHeadY++;
                    break;
                    case "D" : positionHeadY--;
                    break;
                }

                // . T T T .
                // . T H T .
                // . T T T .
                // or H and T are on the same spot
                if (Math.abs(positionHeadX - positionTailX) <= 1 && Math.abs(positionHeadY - positionTailY) <= 1) {
                }

                 else if (positionHeadY == positionTailY) {
                    // T . H . .
                    if (positionHeadX > positionTailX) {
                        positionTailX = positionHeadX - 1;
                    }
                    // . . H . T
                    else {
                        positionTailX = positionHeadX + 1;
                    }
                }
                 else if (positionHeadX == positionTailX) {
                    // . . H . .
                    // . . . . .
                    // . . T . .
                    if (positionHeadY > positionTailY) {
                        positionTailY = positionHeadY - 1;
                    }
                    // . . T . .
                    // . . . . .
                    // . . H . .
                    else {
                        positionTailY = positionHeadY + 1;
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
                else if (positionHeadX - positionTailX >= 2) {
                    positionTailY = positionHeadY;
                    positionTailX = positionHeadX - 1;
                }

                // . . . . .
                // . . . . T
                // . . H . .
                // . . . . T
                // . . . . .
                else if (positionHeadX - positionTailX <= -2) {
                    positionTailY = positionHeadY;
                    positionTailX = positionHeadX + 1;
                }

                // . . . . .
                // . . . . .
                // . . H . .
                // . . . . .
                // . T . T .
                else if (positionHeadY - positionTailY >= 2) {
                    positionTailX = positionHeadX;
                    positionTailY = positionHeadY - 1;
                }

                // . T . T .
                // . . . . .
                // . . H . .
                // . . . . .
                // . . . . .
                else if (positionHeadY - positionTailY <= -2) {
                    positionTailX = positionHeadX;
                    positionTailY = positionHeadY + 1;
                }

                if (!positions.contains(positionTailX + "," + positionTailY)) {
                    positions.add(positionTailX + "," + positionTailY);
                }
            }
        }
        return positions.size();
    }
}
