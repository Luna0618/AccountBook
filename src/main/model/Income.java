package model;

import ui.AccountBookIncome;

public class Income extends MoneyList {
    private AccountBookIncome accountBookIncome;

    public Income() {
        super();
        accountBookIncome = null;
    }

    @Override
    public String view() {
        String printOut = "Today you have earned: " + totalMoney + " dollar.";
        System.out.println(printOut);
        return printOut;
    }

    public int view(String category) {
        int moneyForCategory = moneyForCategory(category);
        System.out.println("You have earned: " + moneyForCategory + " dollars" + " for category: " + category);
        return moneyForCategory;
    }

    public int borrowAndLend() {
        int borrowAndLend = moneyForCategory("borrow");
        System.out.println("Don't forget to pay back friends:" + borrowAndLend + " dollars.");
        return borrowAndLend;
    }

    public void assignAccountBookIncome(AccountBookIncome accountBookIncome) {
        this.accountBookIncome = accountBookIncome;
        accountBookIncome.addIncome();
    }

}