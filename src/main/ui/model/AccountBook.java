package ui.model;

import java.util.ArrayList;
import java.util.List;

public class AccountBook {

    public static int limit = 1000;

    private List<Spending> accountbook;
    private int spendings;


    //EFFECTS: Book is empty
    public AccountBook() {
        accountbook = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: Add new spending to the account book
    public void addSpending(Spending spending) {
        accountbook.add(spending);
    }

    public void viewSpending() {
        if (totalSpendings(accountbook) <= 0) {
            System.out.println("You haven't spend any money today!");
        } else {
            System.out.println("Today you have spent:" + totalSpendings(accountbook) + "dollar.");
        }
    }

    //MODIFIES: spendings
    //EFFECTS: Adding up whole spending
    private int totalSpendings(List<Spending> theList) {
        for (Spending s : theList) {
            spendings = spendings + s.getMoney();
        }
        return spendings;
    }

}
