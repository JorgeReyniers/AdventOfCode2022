package org.example.DayElevenDomain;

import java.util.Objects;

public class Operation {
    private String operator;
    private int amount;

    public Operation(String operator, int amount) {
        this.operator = operator;
        this.amount = amount;
    }

    public boolean isAmountSameAsWorryLevel() {
        return amount == 0;
    }

    public String getOperator() {
        return operator;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return amount == operation.amount && Objects.equals(operator, operation.operator);
    }
}
