package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class ChooseAccountBookTest {
    private ChooseAccountBook chooseAccountBook;

    @BeforeEach
    public void setUp() {
        chooseAccountBook = new ChooseAccountBook();
    }

    @Test
    public void testChooseBook(){
        assertNull(chooseAccountBook.chooseAccountBook(null));
        assertNull(chooseAccountBook.chooseAccountBook("Book"));
    }
}
