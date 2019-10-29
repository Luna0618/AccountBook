package model;

import exceptions.NegativeMoneyException;
import exceptions.UnexpectedAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountBookTest {
    AccountBook expense;
    AccountBook income;
    HashMap moniesExpense;
    HashMap moniesIncome;




    @BeforeEach
    public void setup() {
        expense = new Expense();
        income = new Income();
        moniesExpense = expense.getMonies();
        moniesIncome = income.getMonies();
    }

    @Test
    public void testAdd() throws UnexpectedAmountException {
        assertEquals(0, moniesExpense.size());
        expense.add("food", 10);
        assertEquals(1, moniesExpense.size());
        expense.add("tuitionFee", 2000);
        assertEquals(2, moniesExpense.size());

        assertEquals(0, moniesIncome.size());
        income.add("food" ,10);
        assertEquals(1, moniesIncome.size());
        income.add("tuitionFee", 2000);
        assertEquals(2, moniesIncome.size());
    }

    @Test
    public void testView() throws NegativeMoneyException {
        assertEquals("Today you have spent: 0 dollar.", expense.view());
        expense.add("food",10);
        assertEquals("Today you have spent: 10 dollar.", expense.view());
        expense.add("tuitionFee", 2000);
        assertEquals("Today you have spent: 2010 dollar.", expense.view());

        assertEquals("Today you have earned: 0 dollar.", income.view());
        income.add("food",10);
        assertEquals("Today you have earned: 10 dollar.", income.view());
        income.add("tuitionFee", 2000);
        assertEquals("Today you have earned: 2010 dollar.", income.view());

    }

   @Test
    public void testForCategory() throws NegativeMoneyException {
        Expense expense = new Expense();
        Income income = new Income();
        assertEquals(0, expense.view("food"));
        expense.add("food",10);
        expense.add("tuitionFee", 2000);
        assertEquals(10, expense.view("food"));
        assertEquals(2000, expense.view("tuitionFee"));

       assertEquals(0, income.view("food"));
       income.add("food",10);
       income.add("tuitionFee", 2000);
       assertEquals(10, income.view("food"));
       assertEquals(2000, income.view("tuitionFee"));
   }

   @Test
    public void testBorrowAndLend() throws NegativeMoneyException {
        assertEquals(0,income.borrowAndLend());
        income.add("food",10);
        assertEquals(0,income.borrowAndLend());
        income.add("borrow", 100);
        assertEquals(100,income.borrowAndLend());
        income.add("lend", 100);
        assertEquals(100,income.borrowAndLend());


       assertEquals(0,expense.borrowAndLend());
       expense.add("food",10);
       assertEquals(0,expense.borrowAndLend());
       expense.add("borrow", 100);
       assertEquals(0,expense.borrowAndLend());
       expense.add("lend", 100);
       assertEquals(100,expense.borrowAndLend());

   }
}
