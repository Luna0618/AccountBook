package model;

import java.util.ArrayList;
import java.util.List;

public class Adult extends FamilyMember {
    private List<FamilyMember> familyMembers;

    public Adult(String name) {
        super(name);
        familyMembers = new ArrayList<>();
    }

    //MODIFIES:this
    //EFFECTS:Add a family member to the family members list
    public void addMember(FamilyMember familyMember) {
        familyMembers.add(familyMember);
    }


    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }


    //MODIFIES:this
    //EFFECTS:update each family member int the family members list
    public String update(String category, int amount) {
        super.update(category,amount);
        for (FamilyMember familyMember : familyMembers) {
            familyMember.update(category, amount);
        }
        return "";
    }
}
