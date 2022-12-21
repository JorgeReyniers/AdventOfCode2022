package org.example;

import java.util.ArrayList;

public class DayTen implements Day{
    @Override
    public int execute(ArrayList<String> input) {
        int totalSignalStrength = 0;
        int currentSignalStrength = 1;
        int cycleCount = 0;
        for (String instruction : input) {
            if (instruction.equals("noop")) {
                cycleCount++;
                totalSignalStrength = calculateTotalSignalStrength(totalSignalStrength, currentSignalStrength, cycleCount);
            } else {
                int signalStrength = Integer.parseInt(instruction.split(" ")[1]);
                for (int i = 1 ; i <= 2 ; i++) {
                    cycleCount++;
                    totalSignalStrength = calculateTotalSignalStrength(totalSignalStrength, currentSignalStrength, cycleCount);
                }
                currentSignalStrength += signalStrength;
            }
        }
        return totalSignalStrength;
    }

    private static int calculateTotalSignalStrength(int totalSignalStrength, int currentSignalStrength, int cycleCount) {
        if ((cycleCount == 20 || (cycleCount -20)%40 == 0) && cycleCount < 221) {
            totalSignalStrength += currentSignalStrength*cycleCount;
        }
        return totalSignalStrength;
    }
}
