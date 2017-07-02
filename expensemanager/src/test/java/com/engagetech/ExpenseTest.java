package com.engagetech;

import static io.dropwizard.testing.FixtureHelpers.*;
import static org.assertj.core.api.Assertions.assertThat;
import com.engagetech.expensemanager.core.Expense;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.joda.time.DateTime;
import org.junit.Test;

import java.math.BigDecimal;

public class ExpenseTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        final Expense expense = new Expense(0L, new DateTime(2017, 07, 02, 03,00).toDate(), BigDecimal.valueOf(200), "Because");

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/expense.json"), Expense.class));

        assertThat(MAPPER.writeValueAsString(expense)).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        final Expense expense = new Expense(0L, new DateTime(2017, 07, 02, 03,00).toDate(), BigDecimal.valueOf(200), "Because");
        assertThat(MAPPER.readValue(fixture("fixtures/expense.json"), Expense.class))
                .isEqualTo(expense);
    }
}
