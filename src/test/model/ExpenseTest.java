package model;

import exceptions.ExceedLimitException;
import exceptions.NegativeMoneyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ExpenseTest {
    private Expense expense;
    private HashMap moniesExpense;

    @BeforeEach
    public void setUp() {
        expense = new Expense();
        moniesExpense = expense.getMonies();
    }

    @Test
    public void testView() throws NegativeMoneyException {
        assertEquals("Today you have spent: 0 dollar.", expense.view());
        expense.add("food", 10);
        assertEquals("Today you have spent: 10 dollar.", expense.view());
        expense.add("tuitionFee", 2000);
        assertEquals("Today you have spent: 2010 dollar.", expense.view());
    }

    @Test
    public void testViewForCategory() throws NegativeMoneyException {
        assertEquals(0, expense.view("food"));
        expense.add("food", 10);
        expense.add("tuitionFee", 2000);
        assertEquals(10, expense.view("food"));
        assertEquals(2000, expense.view("tuitionFee"));
    }

    @Test
    public void testBorrowAndLend() throws NegativeMoneyException {
        assertEquals(0, expense.borrowAndLend());
        expense.add("food", 10);
        assertEquals(0, expense.borrowAndLend());
        expense.add("lend", 100);
        assertEquals(100, expense.borrowAndLend());
    }

    @Test
    public void testNotExceedLimit() {
        try {
            expense.add("food", 10);
            assertEquals("You haven't exceed the limit!", expense.exceedLimit());
        } catch (NegativeMoneyException e) {
            fail("No exception should be thrown");
        } catch (ExceedLimitException e) {
            fail("No exception should be thrown");
        }
    }

    @Test
    public void testExceedLimit() {
        try {
            expense.add("food", 2000);
            expense.exceedLimit();
            fail("No exception thrown");
        } catch (NegativeMoneyException e) {
            fail("Wrong exception thrown");
        } catch (ExceedLimitException e) {
            //expected
        }
    }

}
