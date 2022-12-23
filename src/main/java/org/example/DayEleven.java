package org.example;

import org.example.DayElevenDomain.Item;
import org.example.DayElevenDomain.Monkey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayEleven implements Day {
    @Override
    public int execute(ArrayList<String> input) {
        List<Monkey> monkeys = createMonkeys(input);
        for (int i = 1; i <= 20; i++) {
            for (Monkey monkey : monkeys) {
                System.out.println(monkey.getItems());
            }
            System.out.println();
            playKeepAwayRound(monkeys);
        }
        return calculateLevelOfMonkeyBusiness(monkeys);
    }

    private int calculateLevelOfMonkeyBusiness(List<Monkey> monkeys) {
        List<Integer> mostInspected = new ArrayList<>();
        for (Monkey monkey : monkeys) {
            mostInspected.add(monkey.getTotalInspected());
        }
        Collections.sort(mostInspected, Collections.reverseOrder());
        return mostInspected.get(0) * mostInspected.get(1);
    }

    private void playKeepAwayRound(List<Monkey> monkeys) {
        for (Monkey monkey : monkeys) {
            monkey.inspectItems();
            throwToMonkeys(monkey, monkeys);
        }
    }

    private void throwToMonkeys(Monkey monkey, List<Monkey> monkeys) {
        for (Item item : monkey.getItems()) {
            Monkey receivingMonkey = monkeys.get(item.getThrowToMonkeyNumber());
            receivingMonkey.addItem(item);
        }
        monkey.removeAllItems();
    }

    private static Monkey createMonkey(List<Monkey> monkeys, Monkey monkey) {
        if (monkey != null) {
            monkeys.add(monkey);
        }
        monkey = new Monkey();
        return monkey;
    }

    public static List<Monkey> createMonkeys(ArrayList<String> observations) {
        List<Monkey> monkeys = new ArrayList<>();
        Monkey monkey = null;
        for (String observation : observations) {
            if (observation.contains("Monkey")) {
                monkey = createMonkey(monkeys, monkey);
            } else if (observation.contains("Starting")) {
                monkey.createItems(observation);
            } else if (observation.contains("Operation")) {
                monkey.createOperation(observation);
            } else if (observation.contains("Test")) {
                monkey.createDivider(observation);
            } else if (observation.contains("true")) {
                monkey.createDivisibleMonkeyNumber(observation);
            } else if (observation.contains("false")) {
                monkey.createNonDivisibleMonkeyNumber(observation);
            }
        }
        monkeys.add(monkey);
        return monkeys;
    }
}
