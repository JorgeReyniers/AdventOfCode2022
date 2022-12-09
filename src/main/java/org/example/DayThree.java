package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DayThree implements Day {
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public int execute(ArrayList<String> input) {
        int counter = 0;
        List<String> threeElves = new ArrayList<>();
        int totalPriority = 0;
        for (String rucksack : input) {
            counter++;
            threeElves.add(rucksack);
            if (counter >= 3) {
                Character commonChar = findCommonChar(threeElves);
                totalPriority += calculatePriority(commonChar);
                threeElves.clear();
                counter = 0;
            }
        }
        return totalPriority;
    }

    @Override
    public String executeWithStringOutput(ArrayList<String> input) {
        return null;
    }

    private int calculatePriority(Character commonChar) {
        int extraPriority = Character.isUpperCase(commonChar) ? 27 : 1;
        return alphabet.indexOf(Character.toLowerCase(commonChar)) + extraPriority;
    }

    private Character findCommonChar(List<String> threeElves) {
        List<Character> commonChars = new ArrayList<>();
        Optional<Character> theCommonChar = null;
        for (Character itemType: threeElves.get(0).toCharArray()) {
            if (threeElves.get(1).indexOf(itemType) != -1) {
                commonChars.add(itemType);
            }
        }
        int i = 0;
        while (theCommonChar == null) {
            if (commonChars.contains(threeElves.get(2).charAt(i))) {
                theCommonChar = Optional.of(threeElves.get(2).charAt(i));
            }
            i++;
        }
        return theCommonChar.get();
    }
}
