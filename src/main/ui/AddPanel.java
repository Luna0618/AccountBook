package ui;

import exceptions.UnexpectedAmountException;
import model.Adult;
import model.Expense;
import model.Income;
import model.Kid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddPanel extends JPanel implements ActionListener {
    private MainPanel mainPanel;
    private Expense expense;
    private Income income;
    private JTextField categoryField;
    private JTextField amountField;
    private JLabel categoryLabel;
    private JLabel amountLabel;
    private JLabel printOutLabel;
    private Kid tom = new Kid("Tom");
    private Kid peter = new Kid("Peter");
    private Adult dad = new Adult("Dad");
    private Adult mom = new Adult("Mom");
    private List<String> loadData = new ArrayList<>();

    public AddPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        this.setLayout(new GridLayout(3, 2));
        expense = mainPanel.getExpense();
        income = mainPanel.getIncome();
        expense.addObserver(dad);
        expense.addObserver(mom);
        dad.addMember(tom);
        dad.addMember(peter);

    }

    private void setFieldAndLabel() {
        categoryField = new JTextField(10);
        categoryField.addActionListener(this);
        categoryField.setPreferredSize(new Dimension(500, 50));
        categoryField.setFont(new Font("Expense", Font.BOLD, 50));

        amountField = new JTextField(10);
        amountField.addActionListener(this);
        amountField.setPreferredSize(new Dimension(500, 50));
        amountField.setFont(new Font("Expense", Font.BOLD, 50));

        categoryLabel = new JLabel();
        categoryLabel.setText("Enter the category: ");
        categoryLabel.setPreferredSize(new Dimension(500, 100));
        categoryLabel.setFont(new Font("Expense", Font.BOLD, 50));

        amountLabel = new JLabel();
        amountLabel.setText("Enter the amount: ");
        amountLabel.setPreferredSize(new Dimension(500, 100));
        amountLabel.setFont(new Font("Expense", Font.BOLD, 50));

        //Tell accessibility tools about label/textfield pairs.
        categoryLabel.setLabelFor(categoryField);
        amountLabel.setLabelFor(amountField);
    }


    private void addPage() {
        setFieldAndLabel();
        setPrintOutLabel();
        add(categoryLabel);
        add(categoryField);
        add(amountLabel);
        add(amountField);
        add(printOutLabel);
    }

    public void addMoney() {
        JFrame frame = new JFrame("Add");
        //Add contents to the window.
        AddPanel myPanel = new AddPanel(mainPanel);
        myPanel.addPage();
        myPanel.setOpaque(true); //content panes must be opaque
        frame.setContentPane(myPanel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String category = categoryField.getText();
        String amount = amountField.getText();
        int amountInt = Integer.parseInt(amount);
        if (mainPanel.getExpenseOrIncome()) {
            addExpense(category, amountInt);
        } else {
            try {
                income.add(category, amountInt);
                printOutLabel.setText("Add Money Successfully!");
            } catch (UnexpectedAmountException exception) {
                System.out.println("Unexpected amount!");
            }
        }

    }

    private void addExpense(String category, int amountInt) {
        try {
            load();
            expense.add(category, amountInt);
            printOutLabel.setText("Add Money Successfully!");
            save();
        } catch (UnexpectedAmountException | IOException exception) {
            System.out.println("Unexpected amount!");
        }
    }

    private void setPrintOutLabel() {
        printOutLabel = new JLabel();
        printOutLabel.setFont(new Font("Expense", Font.BOLD, 30));

    }

    //MODIFIES:this
    //EFFECTS:Add file data to this account book
    public java.util.List<String> load() throws IOException {
        java.util.List<String> lines = Files.readAllLines(Paths.get("./data/AccountBook.txt"));
        for (String line : lines) {
            ArrayList<String> partsOfLine;
            partsOfLine = splitOnSpace(line);
            try {
                expense.add(partsOfLine.get(0), Integer.parseInt(partsOfLine.get(1)));
            } catch (UnexpectedAmountException e) {
                System.out.println("Unexpected amount!");
            }
        }
        return lines;
    }

    //EFFECTS:Save this account book to data file
    public List<String> save() throws IOException {
        PrintWriter writer = new PrintWriter("./data/AccountBook.txt", "UTF-8");
        for (String s : expense.getMonies().keySet()) {
            for (int i : expense.getMonies().get(s)) {
                String newLine = s + " " + i;
                loadData.add(newLine);
            }
        }
        for (String line : loadData) {
            writer.println(line);
        }
        writer.close();
        return loadData;
    }

    private ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));


    }

}
