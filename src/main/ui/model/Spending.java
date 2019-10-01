package ui.model;

public class Spending {
    private String category;
    private int money;

    public Spending(String c, int m) {
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
