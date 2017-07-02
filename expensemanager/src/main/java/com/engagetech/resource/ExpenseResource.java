package com.engagetech.resource;

import com.codahale.metrics.annotation.Timed;
import com.engagetech.expensemanager.core.Expense;
import com.engagetech.expensemanager.core.ExpenseDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/expenses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExpenseResource {

    ExpenseDAO expenseDAO;

    public ExpenseResource(ExpenseDAO expenseDAO) {
        this.expenseDAO = expenseDAO;
    }

    @GET
    @Timed
    public List<Expense> getExpenses() {
        return expenseDAO.getAll();
    }

    @POST
    public Expense saveExpense(Expense expense) {
        expenseDAO.insert(expense);
        return expense;
    }
}
