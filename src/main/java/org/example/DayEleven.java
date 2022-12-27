package org.example;

import org.example.DayElevenDomain.Item;
import org.example.DayElevenDomain.Monkey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayEleven{
    public long execute(ArrayList<String> input) {
        List<Monkey> monkeys = createMonkeys(input);
        for (int i = 1; i <= 10000; i++) {
            playKeepAwayRound(monkeys);
            System.out.println(i);
            System.out.println("---------------------------");
            System.out.println(calculateLevelOfMonkeyBusiness(monkeys));
            System.out.println();
        }
        return calculateLevelOfMonkeyBusiness(monkeys);
    }

    private long calculateLevelOfMonkeyBusiness(List<Monkey> monkeys) {
        List<Long> mostInspected = new ArrayList<>();
        for (Monkey monkey : monkeys) {
            mostInspected.add(monkey.getTotalInspected());
        }
        System.out.println(mostInspected);
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

    private Monkey createMonkey(List<Monkey> monkeys, Monkey monkey) {
        if (monkey != null) {
            monkeys.add(monkey);
        }
        monkey = new Monkey();
        return monkey;
    }

    public List<Monkey> createMonkeys(ArrayList<String> observations) {
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
