package org.example;

import java.util.ArrayList;

public class DayTwelve implements Day {
    @Override
    public int execute(ArrayList<String> input) {
        String[][] heightMap = createHeightMap(input);
        int[] startingCoordinates = getStartingCoordinates(heightMap);
        return 0;
    }

    public String[][] createHeightMap(ArrayList<String> input) {
        String[][] heightMap = new String[100][500];
        for (int i = 0; i < input.size(); i++) {
            String[] characters = input.get(i).split("");
            for (int j = 0; j < characters.length; j++) {
                heightMap[i][j] = characters[j];
            }
        }
        return heightMap;
    }

    public int[] getStartingCoordinates(String[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j].equals("S")) {
                    return new int[]{j, i};
                }
            }
        }
        return new int[0];
    }
}
