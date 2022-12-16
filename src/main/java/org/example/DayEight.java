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
                }

            }
        }
        return visibleTrees;
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
