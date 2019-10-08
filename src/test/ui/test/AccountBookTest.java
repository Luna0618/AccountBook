package ui.test;

import model.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Money;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountBookTest {
    Expense expense;
    List<Money> field;
    Money s1;
    Money s2;



    @BeforeEach
    public void setup() {
        expense = new Expense();
        field = expense.getMonies();
        s1 = new Money("food",10);
        s2 = new Money("tuitionFee",2000);

    }

    @Test
    public void testAddSpending() {
        assertEquals(0,field.size());
        expense.add(s1);
        assertEquals(1, field.size());
        expense.add(s2);
        assertEquals(2, field.size());
    }

    @Test
    public void testViewSpending() {
        assertEquals(0, expense.getTotalMoney());
        expense.add(s1);
        assertEquals(10, expense.getTotalMoney());
        expense.add(s2);
        assertEquals(2010, expense.getTotalMoney());

    }

    @Test
    public void testExceedLimit() {
        assertEquals("", expense.getPrintOut());
        expense.add(s1);
        expense.exceedLimit();
        assertEquals("You haven't exceed the limit!", expense.getPrintOut());
        expense.add(s2);
        expense.exceedLimit();
        assertEquals("You cannot spend more money!", expense.getPrintOut());
    }

   @Test
    public void testSpendingForCategory() {
        assertEquals(0, expense.forCategory("food"));
        expense.add(s1);
        expense.add(s2);
        assertEquals(10, expense.forCategory("food"));
        assertEquals(2000, expense.forCategory("tuitionFee"));

    }
}
