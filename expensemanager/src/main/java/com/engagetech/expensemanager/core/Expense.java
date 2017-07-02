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
}
