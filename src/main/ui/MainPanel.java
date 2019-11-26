package ui;

import model.Expense;
import model.Income;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {
    private Boolean expenseOrIncome = true;
    private AddPanel addPanel;
    private ViewPanel viewPanel;
    private JButton expenseButton;
    private JButton incomeButton;
    private JButton viewButton;
    private Expense expense;
    private Income income;


    public MainPanel() {
        new JPanel();
        this.setLayout(new GridLayout(3,1));
        expense = new Expense();
        income = new Income();
        this.addPanel = new AddPanel(this);
        this.viewPanel = new ViewPanel(this);

    }

    private void welcomePage() {
        addButton();
        addButtonListener();
        //Add Components to this container, using the default FlowLayout.
        add(expenseButton);
        add(incomeButton);
        add(viewButton);
    }

    private void addButton() {
        expenseButton = new JButton("Add Expense");
        expenseButton.setActionCommand("addExpense");
        expenseButton.setPreferredSize(new Dimension(500,100));
        expenseButton.setFont(new Font("Font", Font.BOLD, 50));

        incomeButton = new JButton("Add Income");
        incomeButton.setActionCommand("addIncome");
        incomeButton.setPreferredSize(new Dimension(500,100));
        incomeButton.setFont(new Font("Font", Font.BOLD, 50));


        viewButton = new JButton("View AccountBook");
        viewButton.setActionCommand("view");
        viewButton.setPreferredSize(new Dimension(500,100));
        viewButton.setFont(new Font("Font", Font.BOLD, 50));
    }

    private void addButtonListener() {
        expenseButton.addActionListener(this);
        incomeButton.addActionListener(this);
        viewButton.addActionListener(this);
    }

    //EFFECTS: Create a new Main Panel
    public void chooseFunction() {
        //Create and set up the window.
        JFrame frame = new JFrame("What you want to do?");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        MainPanel myPanel = new MainPanel();
        myPanel.welcomePage();
        myPanel.setOpaque(true); //content panes must be opaque
        frame.setContentPane(myPanel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if ("addExpense".equals(e.getActionCommand())) {
            expenseOrIncome = true;
            addPanel.addMoney();
        } else if ("addIncome".equals(e.getActionCommand())) {
            expenseOrIncome = false;
            addPanel.addMoney();
        } else if ("view".equals(e.getActionCommand())) {
            viewPanel.chooseFunction();
        }
    }

    public boolean getExpenseOrIncome() {
        return expenseOrIncome;
    }


    public Expense getExpense() {
        return expense;
    }

    public Income getIncome() {
        return income;
    }
}
