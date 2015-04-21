package com.twu.biblioteca;


import java.util.ArrayList;

public class UserAccountController {

    private ArrayList<UserAccount> users;
    private UserAccount currentUser;

    public UserAccountController() {
        users = new ArrayList<UserAccount>();
        addDefaultUsers();
    }

    public UserAccount getCurrentUser() {
        return currentUser;
    }

    public boolean checkIfLoggedIn() {
        if (currentUser != null)
            return true;
        return false;
    }

    public void loginAttemptWithCredentials(String userInputID, String userInputPassword) {

        for (UserAccount user : users) {
            if (user.getId().equals(userInputID) && user.getPassword().equals(userInputPassword))
                currentUser = user;
        }
    }

    public void loginAsAdmin() {
        currentUser = new UserAccount("000-0000", "admin", "admin", "admin@admin.com", "9999 9999");
    }

    public void addDefaultUsers() {
        users.add(new UserAccount("123-4567", "passwordOne", "NameOne", "EmailOne", "phoneOne"));
        users.add(new UserAccount("223-4567", "passwordTwo", "NameTwo", "EmailTwo", "phoneTwo"));
        users.add(new UserAccount("323-4567", "passwordThree", "NameThree", "EmailThree", "phoneThree"));
        users.add(new UserAccount("423-4567", "passwordFour", "NameFour", "EmailFour", "phoneFour"));
    }

    public ArrayList<UserAccount> getUserList() {
        return users;
    }
}
