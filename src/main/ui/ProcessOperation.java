package ui;

import ui.model.AccountBook;
import ui.model.Spending;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProcessOperation implements Savable {
    private Scanner scanner;
    private AccountBook accountBook = new AccountBook();
    private List<String> loadData;

    public void processOperation() throws IOException {
        loadData = load();

        while (true) {
            System.out.println("Type 1 to add spending, 2 to view spending, 3 to check if exceed limit,quit to save.");
            scanner = new Scanner(System.in);
            String operation = scanner.nextLine();
            if (operation.equals("1")) {
                processAddSpending();
            } else if (operation.equals("2")) {
                processViewSpending();
            } else if (operation.equals("3")) {
                accountBook.exceedLimit();
            } else if (operation.equals("quit")) {
                save();
                break;
            }
        }

    }

    private void processAddSpending() {
        System.out.println("Type in the category of the spending:");
        String category = scanner.nextLine();
        System.out.println("Type in the amount of spending:");
        String amountStr = scanner.nextLine();
        int amountInt = Integer.parseInt(amountStr);
        Spending spending = new Spending(category, amountInt);
        accountBook.addSpending(spending);
    }

    private void processViewSpending() {
        String operation;
        System.out.println("Type 1 to view total spending, 2 to view spending for certain category.");
        operation = scanner.nextLine();
        if (operation.equals("1")) {
            accountBook.viewSpending();
        } else if (operation.equals("2")) {
            System.out.println("Which category you want to view?");
            String category = scanner.nextLine();
            System.out.println("You spend " + accountBook.spendingForCategory(category) + " for " + category);

        }
    }

    public List<String> load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./data/AccountBook.txt"));
        for (String line : lines) {
            ArrayList<String> partsOfLine;
            partsOfLine = splitOnSpace(line);
            Spending loadSpending = new Spending(partsOfLine.get(0), Integer.parseInt(partsOfLine.get(1)));
            accountBook.addSpending(loadSpending);
        }
        return lines;
    }

    @Override
    public List<String> save() throws IOException {
        PrintWriter writer = new PrintWriter("./data/AccountBook.txt", "UTF-8");
        for (Spending s : accountBook.getAccountBook()) {
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

    @Override
    public AccountBook getData() {
        return accountBook;
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

