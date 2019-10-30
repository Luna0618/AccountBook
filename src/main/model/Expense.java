package model;

import exceptions.ExceedLimitException;
import ui.AccountBook;

public class Expense extends MoneyList {
    private AccountBook accountBook;

    private static final int LIMIT = 1000;


    //EFFECTS: Expense is empty
    public Expense() {
        super();
        accountBook = null;
    }

    @Override
    public String view() {
        String printOut = "Today you have spent: " + totalMoney + " dollar.";
        System.out.println(printOut);
        return printOut;
    }


    public int view(String category) {
        int forCategory = 0;
        if (monies.containsKey(category)) {
            for (int i : monies.get(category)) {
                forCategory = forCategory + i;
            }
        }
        System.out.println("You have spent: " + forCategory + " dollars" + " for category: " + category);
        return forCategory;
    }

    public int borrowAndLend() {
        int borrowAndLend = 0;
        if (monies.containsKey("lend")) {
            for (int i : monies.get("lend")) {
                borrowAndLend = borrowAndLend + i;
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

    public void assignAccountBook(AccountBook accountBook) {
        this.accountBook = accountBook;
    }

    public Expense getExpense() {
        return accountBook.getData();
    }

}
