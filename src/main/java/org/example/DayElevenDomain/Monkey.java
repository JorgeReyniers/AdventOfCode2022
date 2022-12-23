package org.example.DayElevenDomain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Monkey {
    private List<Item> items;
    private Operation operation;
    private int divider;
    private int divisibleMonkeyNumber;
    private int nonDivisibleMonkeyNumber;
    private int totalInspected = 0;

    public Monkey() {
        items = new ArrayList<>();
    }

    public void createOperation(String observation) {
        observation = observation.replace("  Operation: new = old ", "");
        String[] operation = observation.split(" ");
        int amount = operation[1].equals("old") ? 0 : Integer.parseInt(operation[1]);
        this.operation = new Operation(operation[0], amount);
    }

    public List<Item> getItems() {
        return items;
    }

    public void createDivider(String divider) {
        divider = divider.replace("  Test: divisible by ", "");
        this.divider = Integer.parseInt(divider);
    }

    public void setDivider(int divider) {
        this.divider = divider;
    }

    public void setDivisibleMonkeyNumber(int divisibleMonkeyNumber) {
        this.divisibleMonkeyNumber = divisibleMonkeyNumber;
    }

    public void setNonDivisibleMonkeyNumber(int nonDivisibleMonkeyNumber) {
        this.nonDivisibleMonkeyNumber = nonDivisibleMonkeyNumber;
    }

    public int getTotalInspected() {
        return totalInspected;
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "items=" + items +
                ", operation=" + operation +
                ", divider=" + divider +
                ", divisibleMonkeyNumber=" + divisibleMonkeyNumber +
                ", nonDivisibleMonkeyNumber=" + nonDivisibleMonkeyNumber +
                '}';
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void createItems(String observation) {
        observation = observation.replace("  Starting items: ", "");
        String[] worryLevels = observation.split(", ");
        for (int i = 0; i < worryLevels.length; i++) {
            items.add(new Item(Integer.parseInt(worryLevels[i])));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monkey monkey = (Monkey) o;
        return divider == monkey.divider && divisibleMonkeyNumber == monkey.divisibleMonkeyNumber && nonDivisibleMonkeyNumber == monkey.nonDivisibleMonkeyNumber && Objects.equals(items, monkey.items) && Objects.equals(operation, monkey.operation);
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void createDivisibleMonkeyNumber(String divisibleMonkeyNumber) {
        divisibleMonkeyNumber = divisibleMonkeyNumber.replace("    If true: throw to monkey ", "");
        setDivisibleMonkeyNumber(Integer.parseInt(divisibleMonkeyNumber));
    }

    public void createNonDivisibleMonkeyNumber(String nonDivisibleMonkeyNumber) {
        nonDivisibleMonkeyNumber = nonDivisibleMonkeyNumber.replace("    If false: throw to monkey ", "");
        setNonDivisibleMonkeyNumber(Integer.parseInt(nonDivisibleMonkeyNumber));
    }

    public void inspectItems() {
        for (Item item : items) {
            totalInspected++;
            item.setWorryLevel(calculateNewWorryLevel(item));
            int throwToMonkeyNumber = item.getWorryLevel() % divider == 0 ? divisibleMonkeyNumber : nonDivisibleMonkeyNumber;
            item.setThrowToMonkeyNumber(throwToMonkeyNumber);
        }
    }

    private int calculateNewWorryLevel(Item item) {
        int amount = operation.isAmountSameAsWorryLevel() ? item.getWorryLevel() : operation.getAmount();
        if (operation.getOperator().equals("*")) {
            return Math.round((item.getWorryLevel() * amount) / 3);
        } else {
            return Math.round((item.getWorryLevel() + amount) / 3);
        }
    }

    public void removeAllItems() {
        items.clear();
    }
}
