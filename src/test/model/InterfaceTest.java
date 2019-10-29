package model;

import exceptions.NegativeMoneyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.ProcessOperation;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InterfaceTest {
    Savable savable;
    String testString;


    @BeforeEach
    public void setUp() throws NegativeMoneyException {
        savable = new ProcessOperation();
        Expense ab = savable.getData();
        ab.add("testSavable", 10);
        testString = "testSavable 10";
    }
    public List<String> testSavable(Savable s) throws IOException {
        return s.save();
    }


    @Test

    public void testSave() throws IOException {
        List<String> testList = testSavable(savable);
        assertTrue(testList.contains(testString));
    }
}
