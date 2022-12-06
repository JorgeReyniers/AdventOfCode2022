package org.example;

import java.util.*;

public class DayOne {
    public DayOne() {
    }

    public int execute(ArrayList<String> inputDayOne) {
        List<Integer> highestCalories = new ArrayList<>();
        int currentCalories = 0;
        for(String calorie : inputDayOne){
            if (calorie.isEmpty()){
                addCurrentCaloriesWhenHighEnough(highestCalories, currentCalories);
                currentCalories = 0;
            } else {
                currentCalories += Integer.parseInt(calorie);
            }
        }
        addCurrentCaloriesWhenHighEnough(highestCalories, currentCalories);
        return highestCalories.stream().mapToInt(i -> i).sum();
    }

    private static void addCurrentCaloriesWhenHighEnough(List<Integer> highestCalories, int currentCalories) {
        Optional<Integer> lowestCalorie = highestCalories.stream().findFirst();
        if (highestCalories.stream().count() < 3) {
            highestCalories.add(currentCalories);
            Collections.sort(highestCalories);
        } else if (lowestCalorie.get() < currentCalories) {
            highestCalories.remove(0);
            highestCalories.add(currentCalories);
            Collections.sort(highestCalories);
        }
    }
}
