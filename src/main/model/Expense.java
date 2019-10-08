package model;

public class Expense extends AccountBook {
    private static final int LIMIT = 1000;


    //EFFECTS: Expense is empty
    public Expense() {
        super();
    }

    @Override
    public void view() {
        System.out.println("Today you have spent:" + totalMoney + " dollar.");
    }

    @Override
    public int forCategory(String category) {
        int forCategory = 0;
        for (Money s : monies) {
            if (s.getCategory().equals(category)) {
                forCategory = forCategory + s.getMoney();
            }
        }
        System.out.println("You have spent: " + forCategory + " dollars" + " for category: " + category);
        return forCategory;
    }

    //EFFECTS: Check if the total expense exceed the limit.
    public void exceedLimit() {
        if (totalMoney < LIMIT) {
            printOut = "You haven't exceed the limit!";
        } else {
            printOut = "You cannot spend more money!";
        }
        System.out.println(printOut);
    }
}
