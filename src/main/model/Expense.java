package model;

import exceptions.ExceedLimitException;

public class Expense extends AccountBook {
    private static final int LIMIT = 1000;



    //EFFECTS: Expense is empty
    public Expense() {
        super();
    }

    @Override
    public String view() {
        String printOut = "Today you have spent: " + totalMoney + " dollar.";
        System.out.println(printOut);
        return printOut;
    }


    public int view(String category) {
        int forCategory = 0;
        for (Money s : monies) {
            if (s.getCategory().equals(category)) {
                forCategory = forCategory + s.getMoney();
            }
        }
        System.out.println("You have spent: " + forCategory + " dollars" + " for category: " + category);
        return forCategory;
    }

    public int borrowAndLend() {
        int borrowAndLend = 0;
        for (Money m:monies) {
            if (m.getCategory().equals("lend")) {
                borrowAndLend = borrowAndLend + m.getMoney();
            }
        }
        System.out.println("You have lend friends:" + borrowAndLend + " dollars.");
        return borrowAndLend;
    }


    //EFFECTS: Check if the total expense exceed the limit.
    public void exceedLimit() throws ExceedLimitException {
        if (totalMoney < LIMIT) {
            System.out.println("You haven't exceed the limit!");
        } else {
            throw new ExceedLimitException();
        }
    }
}
