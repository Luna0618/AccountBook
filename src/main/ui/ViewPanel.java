package ui;

import model.Expense;
import model.Income;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewPanel extends JPanel implements ActionListener {
    private Boolean expenseOrIncome;
    private JButton expenseButton;
    private JButton incomeButton;
    private JButton viewButton;
    private JButton totalButton;
    private JButton categoryButton;
    private MainPanel mainPanel;
    private Expense expense;
    private Income income;
    private JTextField category;
    private String labelString;
    private JLabel viewLabel;

    public ViewPanel(MainPanel mainPanel) {
        new JPanel();
        this.setLayout(new GridLayout(3,3));
        this.mainPanel = mainPanel;
        expense = mainPanel.getExpense();
        income = mainPanel.getIncome();
        labelString = "";
    }

    private void viewPage() {
        setButton();
        setExpenseAndIncomeButton();
        setLabel();
        add(expenseButton);
        add(incomeButton);
        add(viewButton);
        add(totalButton);
        add(categoryButton);
        addListener();
        setTextField();
        add(category);
        add(viewLabel);
    }

    private void setButton() {
        expenseButton = new JButton("View Expense");
        expenseButton.setActionCommand("viewExpense");
        expenseButton.setPreferredSize(new Dimension(500,100));
        expenseButton.setFont(new Font("Font", Font.BOLD, 50));

        incomeButton = new JButton("View Income");
        incomeButton.setActionCommand("viewIncome");
        incomeButton.setPreferredSize(new Dimension(500,100));
        incomeButton.setFont(new Font("Font", Font.BOLD, 50));


        viewButton = new JButton("View Total");
        viewButton.setActionCommand("viewTotal");
        viewButton.setPreferredSize(new Dimension(500,100));
        viewButton.setFont(new Font("Font", Font.BOLD, 50));
    }

    private void setExpenseAndIncomeButton() {
        totalButton = new JButton("View Total");
        totalButton.setActionCommand("viewTotalMoneyList");
        totalButton.setEnabled(false);
        totalButton.setPreferredSize(new Dimension(500,100));
        totalButton.setFont(new Font("Font", Font.BOLD, 50));

        categoryButton = new JButton("View GivenCategory");
        categoryButton.setActionCommand("viewCategory");
        categoryButton.setEnabled(false);
        categoryButton.setPreferredSize(new Dimension(500,100));
        categoryButton.setFont(new Font("Font", Font.BOLD, 30));
    }

    private void setTextField() {
        category = new JTextField(10);
        category.setEnabled(false);
        category.setPreferredSize(new Dimension(500,100));
        category.setFont(new Font("Font", Font.BOLD, 50));
        category.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expenseOrIncome) {
                    int amount = expense.view(category.getText());
                    labelString = "You have spent " + amount + " for category " + category.getText();
                } else {
                    int amount = income.view(category.getText());
                    labelString = "You have earned " + amount + " for category " + category.getText();
                }
                updateLabel();
            }
        });

    }

    private void addListener() {
        expenseButton.addActionListener(this);
        incomeButton.addActionListener(this);
        viewButton.addActionListener(this);
        totalButton.addActionListener(this);
        categoryButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("viewExpense".equals(e.getActionCommand())) {
            expenseOrIncome = true;
            totalButton.setEnabled(true);
            categoryButton.setEnabled(true);
        } else if ("viewIncome".equals(e.getActionCommand())) {
            expenseOrIncome = false;
            totalButton.setEnabled(true);
            categoryButton.setEnabled(true);
        } else if ("viewTotal".equals(e.getActionCommand())) {
            labelString = "Your balance is " + (income.getTotalMoney() - expense.getTotalMoney()) + " dollars.";
        } else if ("viewTotalMoneyList".equals(e.getActionCommand())) {
            viewTotalMoneyList();
        } else if ("viewCategory".equals(e.getActionCommand())) {
            category.setEnabled(true);
        }
        updateLabel();
    }

    private void viewTotalMoneyList() {
        if (expenseOrIncome) {
            labelString = expense.view();
        } else {
            labelString = income.view();
        }
    }

    public void chooseFunction() {
        //Create and set up the window.
        JFrame frame = new JFrame("View AccountBook");

        //Create and set up the content pane.
        ViewPanel myPanel = new ViewPanel(mainPanel);
        myPanel.viewPage();
        myPanel.setOpaque(true); //content panes must be opaque
        frame.setContentPane(myPanel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    private void setLabel() {
        viewLabel = new JLabel(labelString);
        viewLabel.setFont(new Font("Font", Font.BOLD, 25));
    }

    private void updateLabel() {
        viewLabel.setText(labelString);
    }



}
