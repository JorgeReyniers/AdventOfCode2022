package org.example.DayElevenDomain;

import java.util.Objects;

public class Item {
    private int worryLevel;
    private int throwToMonkeyNumber;

    public Item(int worryLevel) {
        this.worryLevel = worryLevel;
    }

    public int getWorryLevel() {
        return worryLevel;
    }

    public void setWorryLevel(int worryLevel) {
        this.worryLevel = worryLevel;
    }

    public int getThrowToMonkeyNumber() {
        return throwToMonkeyNumber;
    }

    public void setThrowToMonkeyNumber(int throwToMonkeyNumber) {
        this.throwToMonkeyNumber = throwToMonkeyNumber;
    }

    @Override
    public String toString() {
        return "Item{" +
                "worryLevel=" + worryLevel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return worryLevel == item.worryLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(worryLevel);
    }
}
