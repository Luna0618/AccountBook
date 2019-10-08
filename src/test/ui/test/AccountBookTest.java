package ui.test;

import model.AccountBook;
import model.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Money;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountBookTest {
    AccountBook accountBook;
    List<Money> monies;
    Money s1;
    Money s2;



    @BeforeEach
    public void setup() {
        accountBook = new Expense();
        monies = accountBook.getMonies();
        s1 = new Money("food",10);
        s2 = new Money("tuitionFee",2000);

    }

    @Test
    public void testAdd() {
        assertEquals(0,monies.size());
        accountBook.add(s1);
        assertEquals(1, monies.size());
        accountBook.add(s2);
        assertEquals(2, monies.size());
    }

    @Test
    public void testView() {
        assertEquals(0,accountBook.getTotalMoney());
        accountBook.add(s1);
        assertEquals(10, accountBook.getTotalMoney());
        accountBook.add(s2);
        assertEquals(2010, accountBook.getTotalMoney());

    }

    @Test
    public void testExceedLimit() {
        Expense expense = new Expense();
        assertEquals("",expense.getPrintOut());
        expense.add(s1);
        expense.exceedLimit();
        assertEquals("You haven't exceed the limit!", expense.getPrintOut());
        expense.add(s2);
        expense.exceedLimit();
        assertEquals("You cannot spend more money!", expense.getPrintOut());
    }

   @Test
    public void testForCategory() {
        assertEquals(0, accountBook.forCategory("food"));
        accountBook.add(s1);
        accountBook.add(s2);
        assertEquals(10, accountBook.forCategory("food"));
        assertEquals(2000, accountBook.forCategory("tuitionFee"));

    }
}
