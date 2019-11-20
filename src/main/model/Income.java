package model;

public class Income extends MoneyList {

    public Income() {
        super();
    }

    //EFFECTS:Print out the amount of total earnings
    @Override
    public String view() {
        String printOut = "Today you have earned: " + totalMoney + " dollar.";
        System.out.println(printOut);
        return printOut;
    }

    //EFFECTS:Print out the amount of money for given category
    public int view(String category) {
        int moneyForCategory = moneyForCategory(category);
        System.out.println("You have earned: " + moneyForCategory + " dollars" + " for category: " + category);
        return moneyForCategory;
    }

    //EFFECTS: Print out the amount of money for category:borrow
    public int borrowAndLend() {
        int borrowAndLend = moneyForCategory("borrow");
        System.out.println("Don't forget to pay back friends:" + borrowAndLend + " dollars.");
        return borrowAndLend;
    }


}