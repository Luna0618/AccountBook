package model;

import exceptions.ExceedLimitException;
import ui.AccountBookExpense;

public class Expense extends MoneyList {
    private AccountBookExpense accountBookExpense;

    private static final int LIMIT = 1000;


    //EFFECTS: Expense is empty
    public Expense() {
        super();
        accountBookExpense = null;
    }

    @Override
    public String view() {
        String printOut = "Today you have spent: " + totalMoney + " dollar.";
        System.out.println(printOut);
        return printOut;
    }


    public int view(String category) {
        int forCategory = moneyForCategory(category);
        System.out.println("You have spent: " + forCategory + " dollars" + " for category: " + category);
        return forCategory;
    }

    public int borrowAndLend() {
        int borrowAndLend = moneyForCategory("lend");
        System.out.println("You have lend friends:" + borrowAndLend + " dollars.");
        return borrowAndLend;
    }


    //EFFECTS: Check if the total expense exceed the limit.
    public String exceedLimit() throws ExceedLimitException {
        if (totalMoney < LIMIT) {
            String printout = "You haven't exceed the limit!";
            System.out.println(printout);
            return printout;
        } else {
            System.out.println("Exceed limit!");
            throw new ExceedLimitException();
        }
    }

    public void assignAccountBook(AccountBookExpense  accountBookExpense) {
        this.accountBookExpense = accountBookExpense;
        accountBookExpense.addExpense();
    }

}
