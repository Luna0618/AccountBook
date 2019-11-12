package ui;

import exceptions.ExceedLimitException;
import exceptions.UnexpectedAmountException;
import model.Adult;
import model.Expense;
import model.Kid;

import java.util.Scanner;

public class ProcessExpense {
    private static Expense expense;
    Kid me = new Kid("Me");
    Adult dad = new Adult("Dad");
    Adult grandpa = new Adult("grandpa");

    public ProcessExpense() {
        expense = new Expense();
        expense.addObserver(grandpa);
        grandpa.addMember(dad);
        dad.addMember(me);
    }

    public void addExpense() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Remove the mis-adding? Type in the category. Type skip to skip");
        String response = scanner.nextLine();
        if (! (response.equals("skip"))) {
            expense.remove(response);
        }
        System.out.println("Type in the category of money:");
        String category = scanner.nextLine();
        System.out.println("Type in the amount of money:");
        String amountStr = scanner.nextLine();
        int amountInt = Integer.parseInt(amountStr);
        try {
            expense.add(category, amountInt);
        } catch (UnexpectedAmountException e) {
            System.out.println("Unexpected amount!");
        }
    }

    public  void processViewExpense() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 1 to view total spending, 2 to view spending for specific category.");
        String operation = scanner.nextLine();
        if (operation.equals("1")) {
            expense.view();
            expense.borrowAndLend();
        } else if (operation.equals("2")) {
            System.out.println("Which category you want to view?");
            String category = scanner.nextLine();
            expense.view(category);
        }
        try {
            expense.exceedLimit();
        } catch (ExceedLimitException e) {
            System.out.println("You have exceed the limit!");
        } finally {
            System.out.println("Manage your money wisely!");
        }
    }

    public static Expense getExpense() {
        return expense;
    }


}
