package model;

import java.util.ArrayList;

public abstract class AccountBook {
    protected ArrayList<Money> monies;
    protected int totalMoney = 0;

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
    public abstract String view();


    //EFFECTS: Return the monies ArrayList in AccountBook.
    public ArrayList<Money> getMonies() {
        return monies;
    }

    //EFFECTS: Return the totalMoney in AccountBook.
    public int getTotalMoney() {
        return totalMoney;
    }

    public abstract int borrowAndLend();

}
