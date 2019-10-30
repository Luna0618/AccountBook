package ui;

import exceptions.NegativeMoneyException;
import model.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaveLoadTest {
    AccountBook po;
    Expense ab;
    String testString;

    @BeforeEach
    public void setUp() throws NegativeMoneyException {
        po = new AccountBook();
        ab = po.getData();
        ab.add("testSavable", 10);
        testString = "testSavable 10";
    }
    @Test
    public void testSave() throws IOException {

        po.save();
        List<String> testList = po.save();
        assertTrue(testList.contains(testString));
    }

    @Test
    public void testLoad() throws IOException {
        assertTrue(po.load().contains(testString));

    }

}
