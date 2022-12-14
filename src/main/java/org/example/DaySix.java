package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class DaySix implements Day {
    @Override
    public int execute(ArrayList<String> input) {
        String signal = input.get(0);
        String[] symbols = signal.split("");
        int from = 0;
        String[] subset = Arrays.copyOfRange(symbols, from, from+14);
        while (Arrays.stream(subset).distinct().count() != subset.length) {
            from++;
            subset = Arrays.copyOfRange(symbols, from, from+14);
        }
        return from+14;
    }

    @Override
    public String executeWithStringOutput(ArrayList<String> input) {
        return null;
    }
}
