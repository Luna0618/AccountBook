package ui.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.ProcessOperation;
import ui.model.AccountBook;
import ui.model.Spending;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaveLoadTest {
    ProcessOperation po;
    AccountBook ab;

    @BeforeEach
    public void setUp() {
       po = new ProcessOperation();
        ab = po.getData();

    }
    @Test
    public void testSave() throws IOException {
        Spending s1 = new Spending("testSavable",10);
        ab.addSpending(s1);
        String testString = "testSavable 10";
        List<String> testList = po.save();
        assertTrue(testList.contains(testString));
    }

    @Test
    public void testLoad() throws IOException {
        assertTrue(po.load().contains("TestLoad 30"));

    }

}
