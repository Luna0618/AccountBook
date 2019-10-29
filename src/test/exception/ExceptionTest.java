package exception;

import exceptions.ExceedLimitException;
import exceptions.NegativeMoneyException;
import model.Expense;
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

        try{
            accountBook.add("food",10);
        } catch (NegativeMoneyException e) {
            fail("Shouldn't throw exception!");
        }
    }

    @Test
    public void testAddNegativeException() {
        try {
            accountBook.add("food" ,-10);
            fail("Didn't throw exception!");
        } catch (NegativeMoneyException e) {

        }
    }

    @Test
    public void testExceedNoException() throws NegativeMoneyException {

        accountBook.add("food", 10);
        try {
            accountBook.exceedLimit();
        } catch (ExceedLimitException e) {
            fail("Shouldn't throw exception!");
        }
    }

    @Test
    public void testExceedException() throws NegativeMoneyException {

        accountBook.add("food", 5000);
        try {
            accountBook.exceedLimit();
            fail("Didn't throw exception!");
        } catch (ExceedLimitException e) {

        }
    }

}
