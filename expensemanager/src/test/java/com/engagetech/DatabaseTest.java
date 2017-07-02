package com.engagetech;

import static org.assertj.core.api.Assertions.assertThat;
import com.engagetech.expensemanager.core.Expense;
import com.engagetech.expensemanager.core.ExpenseDAO;
import org.joda.time.DateTime;
import org.junit.Test;

import java.math.BigDecimal;

public class DatabaseTest extends JdbiUnitTest{

    private ExpenseDAO expenseDAO;

    @Test
    public void createsExpense() {
        Expense expense = new Expense(0L, new DateTime(2017, 07, 02, 03,00).toDate(), BigDecimal.valueOf(200), "Because");

        expenseDAO.insert(expense);

        assertThat(expenseDAO.getAll().contains(expense));
    }

    @Override
    protected void setUpDataAccessObjects() {
        expenseDAO = getDbi().onDemand(ExpenseDAO.class);
    }
}
