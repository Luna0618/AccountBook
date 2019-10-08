package ui;

import model.Expense;
import model.Income;
import model.Money;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProcessOperation implements Savable {
    private Expense expense = new Expense();
    private Income income = new Income();
    private List<String> loadData = new ArrayList<>();

    public void processOperation() throws IOException {
        loadData = load();
        while (true) {
            System.out.println("Type 1 to add expense, 2 to add income, 3 to view AccountBook,quit to save.");
            Scanner scanner = new Scanner(System.in);
            String operation = scanner.nextLine();
            if (operation.equals("1")) {
                addExpense();
            } else if (operation.equals("2")) {
                addIncome();
            } else if (operation.equals("3")) {
                processView();
            } else if (operation.equals("quit")) {
                save();
                break;
            }
        }

    }

    public void addExpense() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in the category of money:");
        String category = scanner.nextLine();
        System.out.println("Type in the amount of money:");
        String amountStr = scanner.nextLine();
        int amountInt = Integer.parseInt(amountStr);
        Money money = new Money(category, amountInt);
        expense.add(money);
    }

    public void addIncome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in the category of money:");
        String category = scanner.nextLine();
        System.out.println("Type in the amount of money:");
        String amountStr = scanner.nextLine();
        int amountInt = Integer.parseInt(amountStr);
        Money money = new Money(category, amountInt);
        income.add(money);
    }

    public void processView() {
        Scanner scanner = new Scanner(System.in);
        String operation;
        System.out.println("Type 1 to view total money, 2 to  view expense, 3 to view income");
        operation = scanner.nextLine();
        if (operation.equals("1")) {
            System.out.println("Your balance:" + (income.getTotalMoney() - expense.getTotalMoney()));
        } else if (operation.equals("2")) {
            processViewExpense();
        } else if (operation.equals("3")) {
            processViewIncome();
        }

    }

    public void processViewExpense() {
        Scanner scanner = new Scanner(System.in);
        String operation;
        System.out.println("Type 1 to view total spending, 2 to view spending for specific category.");
        operation = scanner.nextLine();
        if (operation.equals("1")) {
            expense.view();
        } else if (operation.equals("2")) {
            System.out.println("Which category you want to view?");
            String category = scanner.nextLine();
            expense.forCategory(category);
        }
        expense.exceedLimit();
    }

    public void processViewIncome() {
        Scanner scanner = new Scanner(System.in);
        String operation;
        System.out.println("Type 1 to view total income, 2 to view income for specific category.");
        operation = scanner.nextLine();
        if (operation.equals("1")) {
            income.view();
        } else if (operation.equals("2")) {
            System.out.println("Which category you want to view?");
            String category = scanner.nextLine();
            income.forCategory(category);
        }
    }

    public List<String> load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./data/AccountBook.txt"));
        for (String line : lines) {
            ArrayList<String> partsOfLine;
            partsOfLine = splitOnSpace(line);
            Money loadMoney = new Money(partsOfLine.get(0),
                    Integer.parseInt(partsOfLine.get(1)));
            expense.add(loadMoney);
        }
        return lines;
    }

    @Override
    public List<String> save() throws IOException {
        PrintWriter writer = new PrintWriter("./data/AccountBook.txt", "UTF-8");
        for (Money s : expense.getMonies()) {
            String newLine = s.getCategory() + " " + s.getMoney();
            loadData.add(newLine);
        }
        for (String line : loadData) {
            ArrayList<String> partsOfLine;
            partsOfLine = splitOnSpace(line);
            System.out.print("Category: " + partsOfLine.get(0) + " ");
            System.out.println("Money spent: " + partsOfLine.get(1));
            writer.println(line);
        }
        writer.close();
        return loadData;
    }

    public Expense getData() {
        return expense;
    }

    private static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }


    public static void main(String[] args) throws IOException {
        ProcessOperation po = new ProcessOperation();
        po.processOperation();

    }


}

