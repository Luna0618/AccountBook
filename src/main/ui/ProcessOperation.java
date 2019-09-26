package ui;

import ui.model.Spending;
import ui.model.AccountBook;

import java.util.Scanner;

public class ProcessOperation {
    private Scanner scanner;
    private String category;
    private String amount;
    private int amountInt;
    private Spending spending;
    private AccountBook accountBook = new AccountBook();


    public void processOperation() {
        scanner = new Scanner(System.in);
        String operation = "";

        while (true) {
            System.out.println("Type 1 for add spending, 2 for view balance, 3 to check if exceed limit, quit to quit");
            operation = scanner.nextLine();

            if (operation.equals("1")) {
                processAddSpending();
            } else if (operation.equals("2")) {
                accountBook.viewSpending();
            } else if (operation.equals("3")) {
                accountBook.exceedLimit();
            } else if (operation.equals("quit")) {
                break;
            }

        }
    }

    private void processAddSpending() {
        System.out.println("Type in the category of the spending");
        category = scanner.nextLine();
        System.out.println("Type in the amount of spending");
        amount = scanner.nextLine();
        amountInt = Integer.parseInt(amount);
        spending = new Spending(category, amountInt);
        accountBook.addSpending(spending);


    }

    public static void main(String[] args) {
        new ProcessOperation().processOperation();
    }
}

