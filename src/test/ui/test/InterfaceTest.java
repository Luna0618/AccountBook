package ui.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.ProcessOperation;
import ui.Savable;
import model.Money;
import model.Expense;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InterfaceTest {
    Savable savable;
    String testString;


    @BeforeEach
    public void setUp() {
        savable = new ProcessOperation();
        Expense ab = savable.getData();
        Money s1 = new Money("testSavable",10);
        ab.add(s1);
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
