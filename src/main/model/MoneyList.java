package model;

import exceptions.NegativeMoneyException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public abstract class MoneyList {
    protected HashMap<String, LinkedList<Integer>> monies;
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
            monies.put(category, new LinkedList<>());
            LinkedList<Integer> moneyList = monies.get(category);
            moneyList.add(money);
            totalMoney = totalMoney + money;
            System.out.println("Add money successfully!");
        }
    }

    public void remove(String category) {
        LinkedList<Integer> moneyList = monies.get(category);
        totalMoney = totalMoney - moneyList.get(moneyList.size() - 1);
        moneyList.remove(moneyList.size() - 1);
        System.out.println("Remove money successfully!");
    }


    //EFFECTS: print out total expense/income in MoneyList;
    public abstract String view();


    //EFFECTS: Return the monies ArrayList in MoneyList.
    public HashMap<String, LinkedList<Integer>> getMonies() {
        return monies;
    }

    //EFFECTS: Return the totalMoney in MoneyList.
    public int getTotalMoney() {
        return totalMoney;
    }

    public abstract int borrowAndLend();

    public int moneyForCategory(String category) {
        int moneyForCategory = 0;
        if (monies.containsKey(category)) {
            for (int i : monies.get(category)) {
                moneyForCategory = moneyForCategory + i;
            }
        }
        return moneyForCategory;
    }

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
