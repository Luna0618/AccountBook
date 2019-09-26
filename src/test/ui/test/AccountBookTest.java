package ui.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.model.AccountBook;
import ui.model.Spending;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountBookTest {
    AccountBook accountBook;
    List<Spending> field;
    Spending s1;
    Spending s2;



    @BeforeEach
    public void setup() {
        accountBook = new AccountBook();
        field = accountBook.getAccountBook();
        s1 = new Spending("food",10);
        s2 = new Spending("tuitionFee",2000);

    }

    @Test
    public void testAddSpending() {
        assertEquals(0,field.size());
        accountBook.addSpending(s1);
        assertEquals(1, field.size());
        accountBook.addSpending(s2);
        assertEquals(2, field.size());
    }

    @Test
    public void testViewSpending() {
        assertEquals(0,accountBook.getTotalSpending());
        accountBook.addSpending(s1);
        assertEquals(10,accountBook.getTotalSpending());
        accountBook.addSpending(s2);
        assertEquals(2010,accountBook.getTotalSpending());

    }

    @Test
    public void testExceedLimit() {
        assertEquals("",accountBook.getPrintOut());
        accountBook.addSpending(s1);
        accountBook.exceedLimit();
        assertEquals("You haven't exceed the limit!",accountBook.getPrintOut());
        accountBook.addSpending(s2);
        accountBook.exceedLimit();
        assertEquals("You cannot spend more money!",accountBook.getPrintOut());
    }
}
