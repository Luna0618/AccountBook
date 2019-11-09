package ui;

import exceptions.NegativeMoneyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaveLoadTest {
    AccountBook po;
    String testString;

    @BeforeEach
    public void setUp() throws NegativeMoneyException {
        po = new AccountBook();
        po.getProcessExpense().getExpense().add("testSavable", 10);
        testString = "testSavable 10";
    }
    @Test
    public void testSave() throws IOException {
        po.load();
        List<String> testList = po.save();
        assertTrue(testList.contains(testString));
    }

    @Test
    public void testLoad() throws IOException {
        assertTrue(po.load().contains(testString));

    }

}
