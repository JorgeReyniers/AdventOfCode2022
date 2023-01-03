package org.example.DayElevenDomain;

public class Item {
    private long worryLevel;
    private int throwToMonkeyNumber;

    public Item(int worryLevel) {
        this.worryLevel = worryLevel;
    }

    public long getWorryLevel() {
        return worryLevel;
    }

    public void setWorryLevel(long worryLevel) {
        this.worryLevel = worryLevel;
    }

    public int getThrowToMonkeyNumber() {
        return throwToMonkeyNumber;
    }

    public void setThrowToMonkeyNumber(int throwToMonkeyNumber) {
        this.throwToMonkeyNumber = throwToMonkeyNumber;
    }

    @Override
    public boolean equals(Object o) {
        Item item = (Item) o;
        return worryLevel == item.worryLevel;
    }
}
