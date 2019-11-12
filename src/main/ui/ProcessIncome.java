package ui;

import exceptions.UnexpectedAmountException;
import model.Income;

import java.util.Scanner;

public class ProcessIncome {
    private static Income income;

    public ProcessIncome() {
        income = new Income();
    }

    public void addIncome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Remove the mis-adding? Type in the category.Type skip tp skip.");
        String response = scanner.nextLine();
        if (!(response.equals("skip"))) {
            income.remove(response);
        }
        System.out.println("Type in the category of money:");
        String category = scanner.nextLine();
        System.out.println("Type in the amount of money:");
        String amountStr = scanner.nextLine();
        int amountInt = Integer.parseInt(amountStr);
        try {
            income.add(category, amountInt);
        } catch (UnexpectedAmountException e) {
            System.out.println("Unexpected amount!");
        }
    }

    public static void processViewIncome() {
        Scanner scanner = new Scanner(System.in);
        String operation;
        System.out.println("Type 1 to view total income, 2 to view income for specific category.");
        operation = scanner.nextLine();
        if (operation.equals("1")) {
            income.view();
            income.borrowAndLend();
        } else if (operation.equals("2")) {
            System.out.println("Which category you want to view?");
            String category = scanner.nextLine();
            income.view(category);
        }
    }

    public static Income getIncome() {
        return income;
    }
}
