package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class DayEight implements Day{
    @Override
    public int execute(ArrayList<String> input) {
        int[][] treeMap = new int[input.size()][input.get(0).length()];
        fillTreeMap(input, treeMap);
        System.out.println(Arrays.deepToString(treeMap));
        return countVisibleTrees(treeMap);
    }

    private int countVisibleTrees(int[][] treeMap) {
        int visibleTrees = 0;
        for (int i = 0 ; i < treeMap.length ; i++) {
            for (int j = 0 ; j < treeMap[i].length ; j++) {
                if (i == 0 || i == treeMap.length - 1 || j == 0 || j == treeMap[i].length - 1) {
                    visibleTrees++;
                    continue;
                }

                //check left side
                if (isHorizontallyVisible(0, j, j, treeMap[i])) {
                    visibleTrees++;
                    continue;
                }

                //check right side
                if (isHorizontallyVisible(j+1, treeMap[i].length, j, treeMap[i])) {
                    visibleTrees++;
                    continue;
                }

                if (isVerticallyVisible(treeMap, 0, i, i, j)) {
                    visibleTrees++;
                    continue;
                }

                if (isVerticallyVisible(treeMap, i+1, treeMap.length, i, j)) {
                    visibleTrees++;
                }
            }
        }
        return visibleTrees;
    }

    private boolean isHorizontallyVisible(int start, int end, int horizontalPosition, int[] verticalLine) {
        boolean isVisible = true;
        for (int k = start ; k < end ; k++) {
            if (verticalLine[k] >= verticalLine[horizontalPosition]) {
                isVisible = false;
                break;
            }
        }

        return isVisible;
    }

    private boolean isVerticallyVisible(int[][] treeMap, int start, int end, int verticalPosition, int horizontalPosition) {
        boolean isVisible = true;
        for (int k = start; k < end ; k++) {
            if (treeMap[k][horizontalPosition] >= treeMap[verticalPosition][horizontalPosition]) {
                isVisible = false;
                break;
            }
        }
        return isVisible;
    }

    private static void fillTreeMap(ArrayList<String> input, int[][] treeMap) {
        for (int i = 0; i < input.size() ; i++) {
            String[] trees = input.get(i).split("");
            for (int j = 0 ; j < trees.length ; j++) {
                treeMap[i][j] = Integer.parseInt(trees[j]);
            }
        }
    }
}
