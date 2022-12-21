package org.example;

import java.util.ArrayList;

public class DayTen implements Day{
    @Override
    public int execute(ArrayList<String> input) {
        int spritePosition = 0;
        int drawPosition = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (String instruction : input) {
            if (instruction.equals("noop")) {
                if (draw(spritePosition, drawPosition, stringBuilder)) {
                    drawPosition = 0;
                } else {
                    drawPosition++;
                };
            } else {
                int signalStrength = Integer.parseInt(instruction.split(" ")[1]);
                for (int i = 1 ; i <= 2 ; i++) {
                    if (draw(spritePosition, drawPosition, stringBuilder)) {
                        drawPosition = 0;
                    } else {
                        drawPosition++;
                    }
                }
                spritePosition += signalStrength;
            }
        }
        System.out.println(stringBuilder);
        return 0;
    }

    private static boolean draw(int spritePosition, int drawPosition, StringBuilder stringBuilder) {
        if (drawPosition == spritePosition || drawPosition == spritePosition +1 || drawPosition == spritePosition +2) {
            stringBuilder.append('#');
        } else {
            stringBuilder.append('.');
        }

        if (drawPosition == 39) {
            stringBuilder.append(System.lineSeparator());
            return true;
        }

        return false;
    }
}
