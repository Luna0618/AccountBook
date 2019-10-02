package ui;

import java.io.IOException;

public interface Inputable {
    void processOperation() throws IOException;

    String getUserInput();
}
