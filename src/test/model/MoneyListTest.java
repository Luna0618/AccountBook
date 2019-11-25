package model;

import exceptions.NegativeMoneyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyListTest {
    private MoneyList expense;
    private HashMap moniesExpense;




    @BeforeEach
    public void setup() {
        expense = new Expense();
        moniesExpense = expense.getMonies();
    }

    @Test
    public void testAddNoException() {
        try {
            expense.add("food",10);
            assertEquals(1,moniesExpense.size());
            assertEquals(10,expense.getTotalMoney());
        } catch (NegativeMoneyException e) {
            fail("No exception should be thrown");
        }
    }

    @Test
    public void testAddThrowException() {
        try {
            expense.add("food",-10);
            fail("Exception does not thrown");
        } catch (NegativeMoneyException e) {
            //expected
        }
    }

    @Test
    public void testMoneyForCategory() throws NegativeMoneyException {
        assertEquals(0,expense.moneyForCategory("food"));
        expense.add("food",10);
        assertEquals(10,expense.moneyForCategory("food"));
        assertEquals(0,expense.moneyForCategory("drinks"));
    }

}
