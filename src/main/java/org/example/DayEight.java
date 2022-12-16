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
        int scenicScore = 0;
        for (int i = 0 ; i < treeMap.length ; i++) {
            for (int j = 0 ; j < treeMap[i].length ; j++) {
                if (i == 0 || i == treeMap.length - 1 || j == 0 || j == treeMap[i].length - 1) {
                    continue;
                }

                int horizontalFrontScore = calculateScoreHorizontallyFront(j-1, 0, j, treeMap[i]);

                int horizontalBackScore = calculateScoreHorizontally(j+1, treeMap[i].length, j, treeMap[i]);

                int verticalFrontScore = calculateScoreVerticallyFront(treeMap, i-1, 0, i, j);

                int verticalBackScore = calculateScoreVertically(treeMap, i+1, treeMap.length, i, j);

                int treeScenicScore = horizontalFrontScore * horizontalBackScore * verticalFrontScore * verticalBackScore;
                if (treeScenicScore > scenicScore) scenicScore = treeScenicScore;
            }
        }
        return scenicScore;
    }

    private int calculateScoreHorizontallyFront(int start, int end, int horizontalPosition, int[] verticalLine) {
        int score = 0;
        for (int k = start ; k >= end ; k--) {
            if (verticalLine[k] < verticalLine[horizontalPosition]) {
                score++;
            } else {
                score++;
                break;
            }
        }
        if (score == 0) score++;
        return score;
    }

    private int calculateScoreHorizontally(int start, int end, int horizontalPosition, int[] verticalLine) {
        int score = 0;
        for (int k = start ; k < end ; k++) {
            if (verticalLine[k] < verticalLine[horizontalPosition]) {
                score++;
            } else {
                score++;
                break;
            }
        }
        if (score == 0) score++;
        return score;
    }

    private int calculateScoreVerticallyFront(int[][] treeMap, int start, int end, int verticalPosition, int horizontalPosition) {
        int score = 0;
        for (int k = start; k >= end ; k--) {
            if (treeMap[k][horizontalPosition] < treeMap[verticalPosition][horizontalPosition]) {
                score++;
            } else {
                score++;
                break;
            }
        }
        if (score == 0) score++;
        return score;
    }

    private int calculateScoreVertically(int[][] treeMap, int start, int end, int verticalPosition, int horizontalPosition) {
        int score = 0;
        for (int k = start; k < end ; k++) {
            if (treeMap[k][horizontalPosition] < treeMap[verticalPosition][horizontalPosition]) {
                score++;
            } else {
                score++;
                break;
            }
        }
        if (score == 0) score++;
        return score;
    }

    private void fillTreeMap(ArrayList<String> input, int[][] treeMap) {
        for (int i = 0; i < input.size() ; i++) {
            String[] trees = input.get(i).split("");
            for (int j = 0 ; j < trees.length ; j++) {
                treeMap[i][j] = Integer.parseInt(trees[j]);
            }
        }
    }
}
