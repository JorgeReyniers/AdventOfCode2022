package org.example.DayElevenDomain;

import java.math.BigInteger;
import java.util.Objects;

public class Operation {
    private String operator;
    private long amount;

    public Operation(String operator, long amount) {
        this.operator = operator;
        this.amount = amount;
    }

    public boolean isAmountSameAsWorryLevel() {
        return amount == 0;
    }

    public String getOperator() {
        return operator;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        Operation operation = (Operation) o;
        return amount == operation.amount && Objects.equals(operator, operation.operator);
    }
}
