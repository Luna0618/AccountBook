package ui.test;

import model.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.ProcessOperation;
import model.Money;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaveLoadTest {
    ProcessOperation po;
    Expense ab;
    String testString;

    @BeforeEach
    public void setUp() {
        po = new ProcessOperation();
        ab = po.getData();
        Money s1 = new Money("testSavable",10);
        ab.add(s1);
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
