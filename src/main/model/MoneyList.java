package model;

import exceptions.NegativeMoneyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public abstract class MoneyList {
    protected HashMap<String, ArrayList<Integer>> monies;
    protected int totalMoney = 0;


    public MoneyList() {
        monies = new HashMap<>();
    }

    //MODIFIES: this, money
    //EFFECTS: Add new money to MoneyList
    public void add(String category, int money) throws NegativeMoneyException {
        if (money < 0) {
            throw new NegativeMoneyException();
        } else {
            monies.put(category, new ArrayList<>());
            ArrayList<Integer> moneyList = monies.get(category);
            moneyList.add(money);
            totalMoney = totalMoney + money;
            System.out.println("Add money successfully!");
        }
    }

    public void remove(String category) {
        ArrayList<Integer> moneyList = monies.get(category);
        totalMoney = totalMoney - moneyList.get(moneyList.size());
        moneyList.remove(moneyList.size());
        System.out.println("Remove money successfully!");
    }


    //EFFECTS: print out total expense/income in MoneyList;
    public abstract String view();


    //EFFECTS: Return the monies ArrayList in MoneyList.
    public HashMap<String, ArrayList<Integer>> getMonies() {
        return monies;
    }

    //EFFECTS: Return the totalMoney in MoneyList.
    public int getTotalMoney() {
        return totalMoney;
    }

    public abstract int borrowAndLend();


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MoneyList that = (MoneyList) o;
        return monies.equals(that.monies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monies);
    }
}
