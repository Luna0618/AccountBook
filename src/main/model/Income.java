package model;

import ui.AccountBook;

public class Income extends MoneyList {
    private AccountBook accountBook;

    public Income() {
        super();
        accountBook = null;
    }

    @Override
    public String view() {
        String printOut = "Today you have earned: " + totalMoney + " dollar.";
        System.out.println(printOut);
        return printOut;
    }

    public int view(String category) {
        int moneyForCategory = 0;
        if (monies.containsKey(category)) {
            for (int i : monies.get(category)) {
                moneyForCategory = moneyForCategory + i;
            }
        }
        System.out.println("You have earned: " + moneyForCategory + " dollars" + " for category: " + category);
        return moneyForCategory;
    }

    public int borrowAndLend() {
        int borrowAndLend = 0;
        if (monies.containsKey("borrow")) {
            for (int i : monies.get("borrow")) {
                borrowAndLend = borrowAndLend + i;
            }
        }
        System.out.println("Don't forget to pay back friends:" + borrowAndLend + " dollars.");
        return borrowAndLend;
    }

    public void assignAccountBook(AccountBook accountBook) {
        this.accountBook = accountBook;
    }

    public Income getIncome() {
        return accountBook.getIncome();
    }
}