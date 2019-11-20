package model;

public abstract class FamilyMember implements Observer {
    private String name;

    public FamilyMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //EFFECTS:Print out a spending
    public String update(String category, int amount) {
        String printOut = amount + " dollars has been spent on " + category;
        System.out.println(printOut);
        return printOut;
    }
}
