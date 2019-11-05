package model;

import exceptions.NegativeMoneyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncomeTest {
    private Income income;
    private HashMap moniesIncome;

    @BeforeEach
    public void setUp() {
        income = new Income();
        moniesIncome = income.getMonies();
    }

    @Test
    public void testView() throws NegativeMoneyException {
        assertEquals("Today you have earned: 0 dollar.", income.view());
        income.add("food", 10);
        assertEquals("Today you have earned: 10 dollar.", income.view());
        income.add("tuitionFee", 2000);
        assertEquals("Today you have earned: 2010 dollar.", income.view());
    }

    @Test
    public void testViewForCategory() throws NegativeMoneyException {
        assertEquals(0, income.view("food"));
        income.add("food", 10);
        income.add("tuitionFee", 2000);
        assertEquals(10, income.view("food"));
        assertEquals(2000, income.view("tuitionFee"));
    }

    @Test
    public void testBorrowAndLand() throws NegativeMoneyException {
        assertEquals(0, income.borrowAndLend());
        income.add("food", 10);
        assertEquals(0, income.borrowAndLend());
        income.add("borrow", 100);
        assertEquals(100, income.borrowAndLend());
    }
}
