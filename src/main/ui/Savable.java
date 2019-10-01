package ui;

import ui.model.AccountBook;

import java.io.IOException;
import java.util.List;

public interface Savable {
    List<String> save() throws IOException;

    AccountBook getData();
}
