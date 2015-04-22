package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {


    private Scanner sc;
    private MovieController movieController;
    private UserAccountController userController;
    private BookController bookController;

    public BibliotecaApp() {
        bookController = new BookController();
        movieController = new MovieController();
        userController = new UserAccountController();
        sc = new Scanner(System.in);
    }


    public static void main(String[] args) {
        BibliotecaApp bib = new BibliotecaApp();
        System.out.println(bib.getWelcomeMessage());
        bib.mainMenu();
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca";
    }

    private void mainMenu() {
        String selection;
        boolean quit = false;

        printMainMenu();

        selection = sc.nextLine();
        switch (Integer.parseInt(selection)) {
            case 1:
                listAvailableItems();
                break;

            case 2:
                checkoutAnItem();
                break;

            case 3:
                returnABook();
                break;

            case 4:
                if (!userController.checkIfLoggedIn())
                    login();
                else
                    displayCurrentUserInformation();
                break;

            case 5:
                System.out.println("Thank you for using Biblioteca");
                quit = true;
                break;

            default:
                System.out.println("Please select a valid option!");

        }
        if (!quit)
            mainMenu();

    }

    private void returnABook() {
        if (!userController.checkIfLoggedIn())
            if (requestLoginAttempt("This option requires you to be logged in"))
                login();

        if (userController.checkIfLoggedIn())
            bookController.returnBook();
    }

    private void checkoutAnItem() {
        if (!userController.checkIfLoggedIn())
            if (requestLoginAttempt("This option requires you to be logged in"))
                login();

        if (userController.checkIfLoggedIn())
            pickItemToCheckout();
    }

    private void listAvailableItems() {
        switch (pickBookOrMovie()) {
            case Book.ITEM_TYPE:
                bookController.printAllBookDetails();
                break;
            case Movie.ITEM_TYPE:
                movieController.printMovieDetails();
                break;
        }
    }

    public void printMainMenu() {
        System.out
                .println("\nWhich of the following would you like to do? (1-4) ");
        System.out.println("1: List available items");
        System.out.println("2: Checkout an item");
        System.out.println("3: Return an item");
        if (userController.getCurrentUser() != null)
            System.out.println("4: Display user information");
        else
            System.out.println("4: Login");
        System.out.println("5: Quit");
    }

    private void displayCurrentUserInformation() {
        System.out.println(userController.getCurrentUser());
    }

    private void login() {
        String userInputID, userInputPassword;

        userInputID = getUserInput("Please enter your library number (xxx-xxxx)");
        userInputPassword = getUserInput("Please enter your password");

        userController.loginAttemptWithCredentials(userInputID, userInputPassword);

        if (!userController.checkIfLoggedIn()) {
            if (requestLoginAttempt("Login failed"))
                login();
            return;
        }
        if (userController.checkIfLoggedIn())
            System.out.println("Successfully logged in as " + userController.getCurrentUser());
    }

    private boolean requestLoginAttempt(String message) {
        System.out.println(message + ", would you like to login? (Y/N)");
        String retry = sc.nextLine();
        return (retry.equalsIgnoreCase("y"));
    }


    private String getUserInput(String message) {
        System.out.println(message);
        return sc.nextLine();
    }

    private int pickBookOrMovie() {
        try {
            System.out.println("\nPlease select the category of items you're interested in: ");
            System.out.println("1: Books");
            System.out.println("2: Movies");
            switch (Integer.parseInt(sc.nextLine())) {
                case 1:
                    return Book.ITEM_TYPE;
                case 2:
                    return Movie.ITEM_TYPE;
            }

        } catch (Exception ignored) {
        }

        System.out.println("Please pick one of the above choices");
        return pickBookOrMovie();
    }

    private void pickItemToCheckout() {
        BibliotecaItem checkedOutItem = null;
        switch (pickBookOrMovie()) {
            case Book.ITEM_TYPE:
                checkedOutItem = bookController.pickBookToCheckout();
                break;
            case Movie.ITEM_TYPE:
                checkedOutItem = movieController.pickMovieToCheckout();
                break;
        }
        if (checkedOutItem != null) {
            userController.currentUserChecksOut(checkedOutItem);
            System.out.println("Thank you! Please enjoy.");
        } else
            System.out.println("That item is not currently available.");
    }

    public void loginAsAdmin() {
        userController.loginAsAdmin();
    }
}
