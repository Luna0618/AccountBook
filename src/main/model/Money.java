package model;

public class Money {
    private String category;
    private int money;

    public Money(String c, int m) {
        category = c;
        money = m;
    }

    public int getMoney() {
        return money;
    }

    public String getCategory() {
        return category;
    }
}
