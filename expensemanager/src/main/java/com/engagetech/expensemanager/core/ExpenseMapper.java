package com.engagetech.expensemanager.core;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseMapper implements ResultSetMapper<Expense> {

    @Override
    public Expense map(int index, ResultSet resultSet, StatementContext ctx) throws SQLException {
        return new Expense(resultSet.getInt("ID"),
                resultSet.getDate("date"),
                resultSet.getBigDecimal("amount"),
                resultSet.getString("reason"));
    }
}
