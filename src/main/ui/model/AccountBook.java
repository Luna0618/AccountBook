package ui.model;

import java.util.ArrayList;
import java.util.List;

public class AccountBook {

    public static final int LIMIT = 1000;

    private ArrayList<Spending> accountBook;
    private int totalSpending = 0;
    private String printOut = "";


    //EFFECTS: AccountBook is empty
    public AccountBook() {
        accountBook = new ArrayList<>();
    }

    //MODIFIES: this, spending
    //EFFECTS: Add new spending to the account book
    public void addSpending(Spending spending) {
        accountBook.add(spending);
        totalSpending = totalSpending + spending.getMoney();
    }

    public void viewSpending() {
        if (totalSpending <= 0) {
            System.out.println("You haven't spend any money today!");
        } else {
            System.out.println("Today you have spent:" + totalSpending + " dollar.");
        }
    }

    //EFFECTS: Check if the total spending exceed the limit.
    public void exceedLimit() {
        if (totalSpending < LIMIT) {
            printOut = "You haven't exceed the limit!";
        } else {
            printOut = "You cannot spend more money!";
        }
        System.out.println(printOut);
    }



    //EFFECTS: Return the accountBook in AccountBook.
    public List<Spending> getAccountBook() {
        return accountBook;
    }

    //EFFECTS: Return the totalSpending in the accountBook.
    public int getTotalSpending() {
        return totalSpending;
    }

    //EFFECTS: Return the printOut String in AccountBook.
    public String getPrintOut() {
        return printOut;
    }
}
