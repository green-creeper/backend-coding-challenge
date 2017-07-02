package com.engagetech;

import static org.assertj.core.api.Assertions.assertThat;
import com.engagetech.expensemanager.core.Expense;
import com.engagetech.expensemanager.core.ExpenseDAO;
import com.engagetech.resource.ExpenseResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.joda.time.DateTime;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExpenseResourceTest extends JdbiUnitTest {

    private static ExpenseDAO expenseDAO;

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Override
    protected void setUpDataAccessObjects() {
        expenseDAO = getDbi().onDemand(ExpenseDAO.class);
    }

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new ExpenseResource(expenseDAO))
            .build();

    private final Expense expense = new Expense(0L, new DateTime(2017, 07, 02, 03,00).toDate(), BigDecimal.valueOf(200), "Because");

    @Test
    public void testPostExpense() {
        assertThat(resources.target("app/expenses").request()
                .post(Entity.entity(expense, MediaType.APPLICATION_JSON_TYPE))
                .getEntity().equals(expense));
    }

    public void testGetExpenses(){
        List<Expense> response = (ArrayList<Expense>) resources.target("app/expenses").request().get().getEntity();

        assertThat(response.contains(expense));
    }
}
