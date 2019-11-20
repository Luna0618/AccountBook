package model;

public interface Observer {

    //EFFECTS: Update concrete observer
    String update(String category, int amount);

}
