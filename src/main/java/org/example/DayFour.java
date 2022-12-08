package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayFour implements Day {
    @Override
    public int execute(ArrayList<String> input) {
        int amount = 0;
        for (String pair : input) {
            String[] sections = pair.split(",");
            List<List<Integer>> sectionRanges = Arrays.stream(sections).map(section -> determineSectionRange(section)).collect(Collectors.toList());
            if (sectionRanges.get(0).containsAll(sectionRanges.get(1)) || sectionRanges.get(1).containsAll(sectionRanges.get(0))) amount++;
        }
        return amount;
    }

    private List<Integer> determineSectionRange(String section) {
        int sectionStart = Integer.parseInt(section.split("-")[0]);
        int sectionEnd = Integer.parseInt(section.split("-")[1]);
        List<Integer> sectionRange = new ArrayList<>();
        for (Integer i = sectionStart; i <= sectionEnd ; i++) {
            sectionRange.add(i);
        }
        return sectionRange;
    }
}
