package model;

public class Income extends AccountBook {

    public Income() {
        super();
    }

    @Override
    public void view() {
        System.out.println("Today you have earned:" + totalMoney + " dollar.");
    }

    @Override
    public void forCategory(String category) {
        int forCategory = 0;
        for (Money s : monies) {
            if (s.getCategory().equals(category)) {
                forCategory = forCategory + s.getMoney();
            }
        }
        System.out.println("You have earned: " + forCategory + " dollars.");
    }
}