package model;

import java.util.ArrayList;
import java.util.List;

public class Adult extends FamilyMember {
    private List<FamilyMember> familyMembers;

    public Adult(String name) {
        super(name);
        familyMembers = new ArrayList<>();
    }

    public void addMember(FamilyMember familyMember) {
        familyMembers.add(familyMember);
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }


    public String update(String category, int amount) {
        for (FamilyMember familyMember : familyMembers) {
            familyMember.update(category, amount);
        }
        return "";
    }
}
