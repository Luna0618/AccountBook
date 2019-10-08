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

    @Override
    public int forCategory(String category) {
        int forCategory = 0;
        for (Money s : monies) {
            if (s.getCategory().equals(category)) {
                forCategory = forCategory + s.getMoney();
            }
        }
        System.out.println("You have earned: " + forCategory + " dollars" + " for category: " + category);
        return forCategory;
    }
}