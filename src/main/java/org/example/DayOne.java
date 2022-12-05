package org.example;

import java.util.ArrayList;

public class DayOne {
    public DayOne() {
    }

    public int execute(ArrayList<String> inputDayOne) {
        int highestCalories = 0;
        int currentCalories = 0;
        for(String calorie : inputDayOne){
            if (calorie.isEmpty()){
                if (currentCalories > highestCalories) highestCalories = currentCalories;
                currentCalories = 0;
            } else {
                currentCalories += Integer.parseInt(calorie);;
            }
        }
        if (currentCalories > highestCalories) highestCalories = currentCalories;
        return highestCalories;
    }
}
