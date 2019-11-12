package model;

import ui.AccountBook;

public class ChooseAccountBook {
    public AccountBook chooseAccountBook(String accountBook) {
        if (accountBook == null) {
            return null;
        }
        if (accountBook.equals("Family")) {
            return new FamilyAccountBook();
        } else if (accountBook.equals("Personal")) {
            return new PersonalAccountBook();
        }
        return null;
    }
}
