package model;

import java.util.ArrayList;

public abstract class AccountBook {
    protected ArrayList<Money> monies;
    protected int totalMoney = 0;
    protected String printOut = "";

    public AccountBook() {
        monies = new ArrayList<>();
    }

    //MODIFIES: this, money
    //EFFECTS: Add new money to AccountBook
    public void add(Money money) {
        monies.add(money);
        totalMoney = totalMoney + money.getMoney();
    }

    //REQUIRES: totalMoney >= 0
    //EFFECTS: print out total expense/income in AccountBook;
    public abstract void view();

    // EFFECTS: print out the total expense/income for given category
    public abstract void forCategory(String category);

    //EFFECTS: Return the monies ArrayList in AccountBook.
    public ArrayList<Money> getMonies() {
        return monies;
    }

    //EFFECTS: Return the totalMoney in AccountBook.
    public int getTotalMoney() {
        return totalMoney;
    }

    //EFFECTS: Return the printOut string in AccountBook.
    public String getPrintOut() {
        return printOut;
    }

}
