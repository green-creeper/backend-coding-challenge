package com.engagetech.expensemanager.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Date;

public class Expense {

    private long id;

    private Date date;

    private BigDecimal amount;

    private String reason;

    @SuppressWarnings("unused")
    public Expense() {

    }

    public Expense(long id, Date date, BigDecimal amount, String reason) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.reason = reason;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonProperty
    public Date getDate() {
        return date;
    }

    @JsonProperty
    public BigDecimal getAmount() {
        return amount;
    }

    @JsonProperty
    public String getReason() {
        return reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;

        if (!date.equals(expense.date)) return false;
        if (!amount.equals(expense.amount)) return false;
        return reason.equals(expense.reason);
    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + reason.hashCode();
        return result;
    }
}
