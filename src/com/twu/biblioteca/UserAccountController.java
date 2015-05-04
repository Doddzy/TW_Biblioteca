package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.Scanner;

public class UserAccountController {

    private ArrayList<UserAccount> users;
    private UserAccount currentUser;
    private Scanner sc;

    public UserAccountController() {
        users = new ArrayList<UserAccount>();
        addDefaultUsers();
    }

    public UserAccount getCurrentUser() {
        return currentUser;
    }

    public void setScanner(Scanner sc) {
        this.sc = sc;
    }

    public boolean checkIfLoggedIn() {
        return currentUser != null;
    }

    public boolean loginAttemptWithCredentials(String userInputID, String userInputPassword) {

        for (UserAccount user : users) {
            if (user.getId().equals(userInputID) && user.getPassword().equals(userInputPassword)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public void loginAsAdmin() {
        currentUser = new UserAccount("000-0000", "admin", "admin", "admin@admin.com", "9999 9999");
    }

    public void addDefaultUsers() {
        users.add(new UserAccount("111-1111", "password", "testName", "testEmail", "testPhoneNumber"));
        users.add(new UserAccount("123-4567", "passwordOne", "NameOne", "EmailOne", "phoneOne"));
        users.add(new UserAccount("223-4567", "passwordTwo", "NameTwo", "EmailTwo", "phoneTwo"));
        users.add(new UserAccount("323-4567", "passwordThree", "NameThree", "EmailThree", "phoneThree"));
        users.add(new UserAccount("423-4567", "passwordFour", "NameFour", "EmailFour", "phoneFour"));
    }

    public ArrayList<UserAccount> getUserList() {
        return users;
    }

    public void currentUserChecksOut(BibliotecaItem checkedOutItem) {
        currentUser.checkoutItem(checkedOutItem);
    }

    public boolean login() {
        String userInputID, userInputPassword;

        userInputID = getUserInput("Please enter your library number (xxx-xxxx)");
        userInputPassword = getUserInput("Please enter your password");

        if (!loginAttemptWithCredentials(userInputID, userInputPassword)) {
            System.out.println("Login failed");
            if (requestLoginAttempt())
                return login();
            else
                return false;
        }
        System.out.println("Successfully logged in as " + getCurrentUser());
        return true;

    }

    public boolean requestLoginAttempt() {
        System.out.println("\nwould you like to login? (Y/N)");
        String retry = sc.nextLine();
        return (retry.equalsIgnoreCase("y"));
    }

    private String getUserInput(String message) {
        System.out.println(message);
        return sc.nextLine();
    }
}
