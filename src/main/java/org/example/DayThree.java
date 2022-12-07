package org.example;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Optional;

public class DayThree implements Day {
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    @Override
    public int execute(ArrayList<String> input) {
        int totalPriority = 0;
        for(String rucksack: input) {
            String compartmentOne = rucksack.substring(0,(rucksack.length()/2));
            String compartmentTwo = rucksack.substring(rucksack.length()/2);
            Character commonChar = findCommonChar(compartmentOne, compartmentTwo);
            totalPriority += calculatePriority(commonChar);
        }
        return totalPriority;
    }

    private int calculatePriority(Character commonChar) {
        int extraPriority = Character.isUpperCase(commonChar) ? 27 : 1;
        return alphabet.indexOf(Character.toLowerCase(commonChar)) + extraPriority;
    }

    private Character findCommonChar(String compartmentOne, String compartmentTwo) {
        Optional<Character> commonChar = null;
        int i = 0;
        while(commonChar == null) {
            Character compartmentOneChar = compartmentOne.charAt(i);
            if (compartmentTwo.indexOf(compartmentOneChar) != -1) {
                commonChar = Optional.ofNullable(compartmentOneChar);
            }
            i++;
        }
        return commonChar.get();
    }
}
