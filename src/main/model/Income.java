package model;

public class Income extends AccountBook {

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
        int moneyForCategory = 0;
        if (monies.keySet().contains(category)) {
            for (int i : monies.get(category)) {
                moneyForCategory = moneyForCategory + i;
            }
        }
        System.out.println("You have earned: " + moneyForCategory + " dollars" + " for category: " + category);
        return moneyForCategory;
    }

    public int borrowAndLend() {
        int borrowAndLend = 0;
        if (monies.keySet().contains("borrow")) {
            for (int i : monies.get("borrow")) {
                borrowAndLend = borrowAndLend + i;
            }
        }
        System.out.println("Don't forget to pay back friends:" + borrowAndLend + " dollars.");
        return borrowAndLend;
    }
}