package ui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AccountBook extends JPanel {
    private List<String> loadData = new ArrayList<>();
    private MainPanel myPanel = new MainPanel();


    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainPanel myPanel = new MainPanel();
                myPanel.chooseFunction();
            }
        });
    }
}

