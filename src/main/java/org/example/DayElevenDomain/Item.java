package org.example.DayElevenDomain;

import java.math.BigInteger;
import java.util.Objects;

public class Item {
    private BigInteger worryLevel;
    private int throwToMonkeyNumber;

    public Item(BigInteger worryLevel) {
        this.worryLevel = worryLevel;
    }

    public BigInteger getWorryLevel() {
        return worryLevel;
    }

    public void setWorryLevel(BigInteger worryLevel) {
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return worryLevel == item.worryLevel;
    }
}
