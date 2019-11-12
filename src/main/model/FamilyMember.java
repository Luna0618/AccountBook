package model;

public abstract class FamilyMember implements Observer {
    private String name;

    public FamilyMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String update(String category, int amount);
}
