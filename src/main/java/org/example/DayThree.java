package org.example;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Optional;

public class DayThree implements Day {

    @Override
    public int execute(ArrayList<String> input) {
        for(String rucksack: input) {
            String compartmentOne = rucksack.substring(0,(rucksack.length()/2)-1);
            String compartmentTwo = rucksack.substring(rucksack.length()/2,rucksack.length()-1);
            Character commonChar = findCommonChar(compartmentOne, compartmentTwo);
        }
        return 0;
    }

    private Character findCommonChar(String compartmentOne, String compartmentTwo) {
        Optional<Character> commonChar = null;
        int i = 0;
        while(commonChar.equals(null)) {
            Character compartmentOneChar = compartmentOne.charAt(i);
        }
        return 'a';
    }
}
