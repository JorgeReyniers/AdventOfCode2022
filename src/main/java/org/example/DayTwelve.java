package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayTwelve implements Day {
    @Override
    public int execute(ArrayList<String> input) {
        String[][] heightMap = createHeightMap(input);
        int[] startingCoordinates = getStartingCoordinates(heightMap);
        return searchForPath(heightMap, startingCoordinates, new ArrayList<>(), 0, 0);
    }

    private int searchForPath(String[][] heightMap, int[] coordinates, List<String> previousCoordinates, int counter, int fastestRoute) {
        counter++;
        int vp = coordinates[1];
        int hp = coordinates[0];
        String currentHeight = heightMap[vp][hp];
        previousCoordinates.add(""+hp+vp);
        if (currentHeight.equals("E")) {
            if (fastestRoute == 0 || counter < fastestRoute) {
                fastestRoute = counter;
            }
            return fastestRoute;
        }
        if (vp > 0 && !previousCoordinates.contains(""+hp+(vp-1)) && alphabeticValue(heightMap[vp-1][hp])-1 <= alphabeticValue(currentHeight)) {
            fastestRoute = searchForPath(heightMap, new int[]{hp, vp-1}, previousCoordinates, counter, fastestRoute);
        }
        if (vp < heightMap.length-1 && !previousCoordinates.contains(""+hp+(vp+1)) && alphabeticValue(heightMap[vp+1][hp])-1 <= alphabeticValue(currentHeight)) {
            fastestRoute = searchForPath(heightMap, new int[]{hp, vp+1}, previousCoordinates, counter, fastestRoute);
        }
        if (hp > 0 && !previousCoordinates.contains(""+(hp-1)+vp) && alphabeticValue(heightMap[vp][hp-1])-1 <= alphabeticValue(currentHeight)) {
            fastestRoute = searchForPath(heightMap, new int[]{hp-1, vp}, previousCoordinates, counter, fastestRoute);
        }
        if (hp < heightMap[0].length-1 && !previousCoordinates.contains(""+(hp+1)+vp) && alphabeticValue(heightMap[vp][hp+1])-1 <= alphabeticValue(currentHeight)) {
            fastestRoute = searchForPath(heightMap, new int[]{hp+1, vp}, previousCoordinates, counter, fastestRoute);
        }

        return fastestRoute;
    }

    private int alphabeticValue(String alphabeticHeight) {
        return "abcdefghijklmnopqrstuvwxyzS".indexOf(alphabeticHeight);
    }

    public String[][] createHeightMap(ArrayList<String> input) {
        String[][] heightMap = new String[input.size()][input.get(0).length()];
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
