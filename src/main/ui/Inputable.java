package ui;

import java.io.IOException;

public interface Inputable {
    String processOperation(String operation) throws IOException;

    String getUserInput();
}
