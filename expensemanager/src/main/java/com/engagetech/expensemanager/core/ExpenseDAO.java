package com.engagetech.expensemanager.core;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(ExpenseMapper.class)
public interface ExpenseDAO {

    @SqlQuery("select * from EXPENSE")
    List<Expense> getAll();

    @SqlUpdate("insert into EXPENSE (date, amount, reason) values (:date, :amount, :reason)")
    int insert(@BindBean Expense expense);
}
