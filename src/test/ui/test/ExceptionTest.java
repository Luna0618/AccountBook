package ui.test;

import exceptions.ExceedLimitException;
import exceptions.NegativeMoneyException;
import model.Expense;
import model.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class ExceptionTest {
    private Expense accountBook;

    @BeforeEach
    public void setUp() {
        accountBook = new Expense();
    }

    @Test
    public void testAddNoException() {
        Money testExpense = new Money("food",10);
        try{
            accountBook.add(testExpense);
        } catch (NegativeMoneyException e) {
            fail("Shouldn't throw exception!");
        }
    }

    @Test
    public void testAddNegativeException() {
        Money testMoney = new Money("food", -10);
        try {
            accountBook.add(testMoney);
            fail("Didn't throw exception!");
        } catch (NegativeMoneyException e) {

        }
    }

    @Test
    public void testExceedNoException() throws NegativeMoneyException {
        Money testMoney = new Money("food" ,10);
        accountBook.add(testMoney);
        try {
            accountBook.exceedLimit();
        } catch (ExceedLimitException e) {
            fail("Shouldn't throw exception!");
        }
    }

    @Test
    public void testExceedException() throws NegativeMoneyException {
        Money testMoney = new Money("food" ,5000);
        accountBook.add(testMoney);
        try {
            accountBook.exceedLimit();
            fail("Didn't throw exception!");
        } catch (ExceedLimitException e) {

        }
    }

}
