package org.example.DayElevenDomain;

import java.math.BigInteger;
import java.util.Objects;

public class Operation {
    private String operator;
    private BigInteger amount;

    public Operation(String operator, BigInteger amount) {
        this.operator = operator;
        this.amount = amount;
    }

    public boolean isAmountSameAsWorryLevel() {
        return amount.equals(new BigInteger("0"));
    }

    public String getOperator() {
        return operator;
    }

    public BigInteger getAmount() {
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
