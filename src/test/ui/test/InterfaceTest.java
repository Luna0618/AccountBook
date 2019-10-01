package ui.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.ProcessOperation;
import ui.Savable;
import ui.model.AccountBook;
import ui.Inputable;
import ui.model.Spending;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InterfaceTest {
    Savable savable;
    Inputable inputable;
    AccountBook ab;

    @BeforeEach
    public void setUp() {
        savable = new ProcessOperation();
        inputable = new ProcessOperation();
        ab = savable.getData();

    }

    @Test
    public void testProcessOperation() throws IOException {
        assertEquals("testInput", inputable.processOperation("testInput"));

    }

    @Test
    public void testSavable() throws IOException {
        Spending s1 = new Spending("testSavable",10);
        ab.addSpending(s1);
        String testString = "testSavable 10";
        List<String> testList = savable.save();
        assertTrue(testList.contains(testString));
    }
}
