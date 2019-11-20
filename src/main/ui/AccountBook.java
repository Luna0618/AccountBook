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
    private ProcessExpense processExpense = new ProcessExpense();
    private ProcessIncome processIncome = new ProcessIncome();
    private List<String> loadData = new ArrayList<>();

    //EFFECTS:Get the user input and decide the next method to execute
    public void processOperation() throws IOException {
        loadData = load();
        while (true) {
            System.out.println("Type 1 to add expense, 2 to add income, 3 to view AccountBook,quit to save.");
            Scanner scanner = new Scanner(System.in);
            String operation = scanner.nextLine();
            if (operation.equals("1")) {
                processExpense.addExpense();
            } else if (operation.equals("2")) {
                processIncome.addIncome();
            } else if (operation.equals("3")) {
                processView();
            } else if (operation.equals("quit")) {
                save();
                break;
            }
        }
    }

    //EFFECTS:Get the user input. If input =="1", calculate the total balance;
    // input =="2", view expense; input =="3",view income
    public void processView() {
        Scanner scanner = new Scanner(System.in);
        String operation;
        System.out.println("Type 1 to view total money, 2 to  view expense, 3 to view income");
        operation = scanner.nextLine();
        if (operation.equals("1")) {
            System.out.println("Your balance:"
                    + (processIncome.getIncome().getTotalMoney()
                    - ProcessExpense.getExpense().getTotalMoney()));
        } else if (operation.equals("2")) {
            processExpense.processViewExpense();
        } else if (operation.equals("3")) {
            processIncome.processViewIncome();
        }

    }

    //MODIFIES:this
    //EFFECTS:Add file data to this account book
    public List<String> load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./data/AccountBook.txt"));
        for (String line : lines) {
            ArrayList<String> partsOfLine;
            partsOfLine = splitOnSpace(line);
            try {
                ProcessExpense.getExpense().add(partsOfLine.get(0), Integer.parseInt(partsOfLine.get(1)));
            } catch (UnexpectedAmountException e) {
                System.out.println("Unexpected amount!");
            }
        }
        return lines;
    }

    //EFFECTS:Save this account book to data file
    @Override
    public List<String> save() throws IOException {
        PrintWriter writer = new PrintWriter("./data/AccountBook.txt", "UTF-8");
        for (String s : ProcessExpense.getExpense().getMonies().keySet()) {
            for (int i : ProcessExpense.getExpense().getMonies().get(s)) {
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


    public ProcessExpense getProcessExpense() {
        return processExpense;
    }

    public ProcessIncome getProcessIncome() {
        return processIncome;
    }

    private ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }


    public static void main(String[] args) throws IOException {
        AccountBook accountBook = new AccountBook();
        accountBook.processOperation();
    }


}

