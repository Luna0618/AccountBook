package model;

public class Income extends MoneyList {

    public Income() {
        super();
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


}