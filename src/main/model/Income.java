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
        int forCategory = 0;
        for (Money s : monies) {
            if (s.getCategory().equals(category)) {
                forCategory = forCategory + s.getMoney();
            }
        }
        System.out.println("You have earned: " + forCategory + " dollars" + " for category: " + category);
        return forCategory;
    }

    public int borrowAndLend() {
        int borrowAndLend = 0;
        for (Money m:monies) {
            if (m.getCategory().equals("borrow")) {
                borrowAndLend = borrowAndLend + m.getMoney();
            }
        }
        System.out.println("Don't forget to pay back friends:" + borrowAndLend + " dollars.");
        return borrowAndLend;
    }
}