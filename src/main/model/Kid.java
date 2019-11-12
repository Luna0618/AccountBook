package model;

public class Kid extends FamilyMember {
    private int limit = 100;

    public Kid(String name) {
        super(name);
    }

    @Override
    public String update(String category, int amount) {
        String printOut;
        if (amount > limit) {
            printOut = "Exceed the kid's spending limit!";
            System.out.println(printOut);
        } else {
            printOut = amount + " dollars has been spent on " + category;
            System.out.println(printOut);
        }
        return printOut;
    }
}
