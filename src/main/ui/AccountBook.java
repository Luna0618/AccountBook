package ui;

import exceptions.UnexpectedAmountException;
import model.Savable;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AccountBook implements Savable {
    private AccountBookExpense accountBookExpense;
    private AccountBookIncome accountBookIncome;
    private List<String> loadData;

    public void processOperation() throws IOException {
        accountBookExpense = new AccountBookExpense();
        accountBookIncome = new AccountBookIncome();
        loadData = load();
        while (true) {
            System.out.println("Type 1 to add expense, 2 to add income, 3 to view MoneyList,quit to save.");
            Scanner scanner = new Scanner(System.in);
            String operation = scanner.nextLine();
            if (operation.equals("1")) {
                accountBookExpense.addExpense();
            } else if (operation.equals("2")) {
                accountBookIncome.addIncome();
            } else if (operation.equals("3")) {
                processView();
            } else if (operation.equals("quit")) {
                save();
                break;
            }
        }
    }

//    public void addExpense() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Remove the mis-adding? Type in the category");
//        String response = scanner.nextLine();
//        expense.remove(response);
//        System.out.println("Type in the category of money:");
//        String category = scanner.nextLine();
//        System.out.println("Type in the amount of money:");
//        String amountStr = scanner.nextLine();
//        int amountInt = Integer.parseInt(amountStr);
//        try {
//            expense.add(category, amountInt);
//        } catch (UnexpectedAmountException e) {
//            System.out.println("Unexpected amount!");
//
//        }
//    }

//    public void addIncome() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Remove the mis-adding? Type in the category");
//        String response = scanner.nextLine();
//        expense.remove(response);
//        System.out.println("Type in the category of money:");
//        String category = scanner.nextLine();
//        System.out.println("Type in the amount of money:");
//        String amountStr = scanner.nextLine();
//        int amountInt = Integer.parseInt(amountStr);
//        try {
//            income.add(category, amountInt);
//        } catch (UnexpectedAmountException e) {
//            System.out.println("Unexpected amount!");
//        }


    public void processView() {
        Scanner scanner = new Scanner(System.in);
        String operation;
        System.out.println("Type 1 to view total money, 2 to  view expense, 3 to view income");
        operation = scanner.nextLine();
        if (operation.equals("1")) {
            System.out.println("Your balance:"
                    + (AccountBookIncome.getIncome().getTotalMoney()
                    - AccountBookExpense.getExpense().getTotalMoney()));
        } else if (operation.equals("2")) {
            accountBookExpense.processViewExpense();
        } else if (operation.equals("3")) {
            accountBookIncome.processViewIncome();
        }

    }

//    public void processViewExpense() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Type 1 to view total spending, 2 to view spending for specific category.");
//        String operation = scanner.nextLine();
//        if (operation.equals("1")) {
//            expense.view();
//            expense.borrowAndLend();
//        } else if (operation.equals("2")) {
//            System.out.println("Which category you want to view?");
//            String category = scanner.nextLine();
//            expense.view(category);
//        }
//        try {
//            expense.exceedLimit();
//        } catch (ExceedLimitException e) {
//            System.out.println("You have exceed the limit!");
//        } finally {
//            System.out.println("Manage your money wisely!");
//        }
//    }

//    public void processViewIncome() {
//        Scanner scanner = new Scanner(System.in);
//        String operation;
//        System.out.println("Type 1 to view total income, 2 to view income for specific category.");
//        operation = scanner.nextLine();
//        if (operation.equals("1")) {
//            income.view();
//            income.borrowAndLend();
//        } else if (operation.equals("2")) {
//            System.out.println("Which category you want to view?");
//            String category = scanner.nextLine();
//            income.view(category);
//        }
//    }

    public List<String> load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./data/MoneyList.txt"));
        for (String line : lines) {
            ArrayList<String> partsOfLine;
            partsOfLine = splitOnSpace(line);
            try {
                AccountBookExpense.getExpense().add(partsOfLine.get(0), Integer.parseInt(partsOfLine.get(1)));
            } catch (UnexpectedAmountException e) {
                System.out.println("Unexpected amount!");
            }
        }
        return lines;
    }

    @Override
    public List<String> save() throws IOException {
        PrintWriter writer = new PrintWriter("./data/MoneyList.txt", "UTF-8");
        for (String s : AccountBookExpense.getExpense().getMonies().keySet()) {
            for (int i : AccountBookExpense.getExpense().getMonies().get(s)) {
                String newLine = s + " " + i;
                loadData.add(newLine);
            }

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

//    public Expense getData() {
//        return expense;
//    }

//    public Income getIncome() {
//        return income;


    public AccountBookExpense getAccountBookExpense() {
        return accountBookExpense;
    }

    public AccountBookIncome getAccountBookIncome() {
        return accountBookIncome;
    }

    private ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }


    public static void main(String[] args) throws IOException {
        AccountBook ab = new AccountBook();
        ab.processOperation();
    }


}

