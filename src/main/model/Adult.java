package model;

import java.util.ArrayList;
import java.util.List;

public class Adult extends FamilyMember {
    private List<FamilyMember> familyMembers;
    private int numberOfFamilies;

    public Adult(String name) {
        super(name);
        familyMembers = new ArrayList<>();
        numberOfFamilies = 0;
    }

    public void addMember(FamilyMember familyMember) {
        familyMembers.add(familyMember);
        numberOfFamilies = numberOfFamilies + 1;
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public int getNumberOfFamilies() {
        return numberOfFamilies + 1;
    }


    public String update(String category, int amount) {
        for (FamilyMember familyMember : familyMembers) {
            familyMember.update(category, amount);
        }
        return "";
    }
}
