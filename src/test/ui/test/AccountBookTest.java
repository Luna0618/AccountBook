package ui.test;

import model.AccountBook;
import model.Expense;
import model.Income;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Money;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountBookTest {
    AccountBook expense;
    AccountBook income;
    List<Money> moniesExpense;
    List<Money> moniesIncome;
    Money s1;
    Money s2;
    Money s3;
    Money s4;




    @BeforeEach
    public void setup() {
        expense = new Expense();
        income = new Income();
        moniesExpense = expense.getMonies();
        moniesIncome = income.getMonies();
        s1 = new Money("food",10);
        s2 = new Money("tuitionFee",2000);
        s3 = new Money("borrow", 100);
        s4 = new Money("lend", 100);

    }

    @Test
    public void testAdd() {
        assertEquals(0, moniesExpense.size());
        expense.add(s1);
        assertEquals(1, moniesExpense.size());
        expense.add(s2);
        assertEquals(2, moniesExpense.size());

        assertEquals(0, moniesIncome.size());
        income.add(s1);
        assertEquals(1, moniesIncome.size());
        income.add(s2);
        assertEquals(2, moniesIncome.size());
    }

    @Test
    public void testView() {
        assertEquals("Today you have spent: 0 dollar.", expense.view());
        expense.add(s1);
        assertEquals("Today you have spent: 10 dollar.", expense.view());
        expense.add(s2);
        assertEquals("Today you have spent: 2010 dollar.", expense.view());

        assertEquals("Today you have earned: 0 dollar.", income.view());
        income.add(s1);
        assertEquals("Today you have earned: 10 dollar.", income.view());
        income.add(s2);
        assertEquals("Today you have earned: 2010 dollar.", income.view());

    }

    @Test
    public void testExceedLimit() {
        Expense expense = new Expense();
        assertEquals("You haven't exceed the limit!",expense.exceedLimit());
        expense.add(s1);
        assertEquals("You haven't exceed the limit!", expense.exceedLimit());
        expense.add(s2);
        assertEquals("You cannot spend more money!", expense.exceedLimit());
    }

   @Test
    public void testForCategory() {
        Expense expense = new Expense();
        Income income = new Income();
        assertEquals(0, expense.view("food"));
        expense.add(s1);
        expense.add(s2);
        assertEquals(10, expense.view("food"));
        assertEquals(2000, expense.view("tuitionFee"));

       assertEquals(0, income.view("food"));
       income.add(s1);
       income.add(s2);
       assertEquals(10, income.view("food"));
       assertEquals(2000, income.view("tuitionFee"));
   }

   @Test
    public void testBorrowAndLend() {
        assertEquals(0,income.borrowAndLend());
        income.add(s1);
        assertEquals(0,income.borrowAndLend());
        income.add(s3);
        assertEquals(100,income.borrowAndLend());
        income.add(s4);
        assertEquals(100,income.borrowAndLend());


       assertEquals(0,expense.borrowAndLend());
       expense.add(s1);
       assertEquals(0,expense.borrowAndLend());
       expense.add(s3);
       assertEquals(0,expense.borrowAndLend());
       expense.add(s4);
       assertEquals(100,expense.borrowAndLend());

   }
}
