package model;

import java.io.IOException;
import java.util.List;

public interface Savable {
    List<String> save() throws IOException;

    Expense getData();
}
