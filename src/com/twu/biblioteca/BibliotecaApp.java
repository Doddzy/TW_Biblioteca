package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {


    private Scanner sc;
    private MovieController movieController;
    private UserAccountController userController;
    private BookController bookController;
    private ItemController activeItemController;

    private static boolean quit = false;
    private static Menu mainMenu;
    private static Menu itemTypeSelection;


    public BibliotecaApp() {
        setScanner(new Scanner(System.in));


        createDefaultMainMenu();
        mainMenu.setScanner(sc);

        setupItemSelectionMenu();
        itemTypeSelection.setScanner(sc);


        bookController = new BookController();
        bookController.setScanner(sc);

        movieController = new MovieController();
        movieController.setScanner(sc);

        userController = new UserAccountController();
        userController.setScanner(sc);

    }

    private void createDefaultMainMenu() {
        mainMenu = new Menu("\nPlease select an option: ", "Please pick one of the above choices");
        mainMenu.addMenuItem("1", "List available items",
                this::listAvailableItems);
        mainMenu.addMenuItem("2", "Checkout an item",
                this::checkoutAnItem);
        mainMenu.addMenuItem("3", "Return an item",
                this::returnABook);
        mainMenu.addMenuItem("4", "Login",
                this::login);
        mainMenu.addMenuItem("5", "Quit",
                this::quit);
    }

    public static void main(String[] args) {
        new BibliotecaApp();
        System.out.println(getWelcomeMessage());
        while (!quit) {
            Runnable option = mainMenu.showMenu();
            option.run();
        }
    }


    public static String getWelcomeMessage() {
        return "Welcome to Biblioteca";
    }


    public void quit() {
        quit = true;
    }

    public void returnABook() {
        if (!userController.checkIfLoggedIn())
            if (userController.requestLoginAttempt())
                login();

        if (userController.checkIfLoggedIn())
            bookController.returnItem();
    }

    public void checkoutAnItem() {
        if (!userController.checkIfLoggedIn())
            if (userController.requestLoginAttempt())
                login();

        if (userController.checkIfLoggedIn())
            pickItemToCheckout();
    }

    public void listAvailableItems() {
        pickItemType().printAvailable();
    }

    public void displayCurrentUserInformation() {
        System.out.println(userController.getCurrentUser());
    }

    public void login() {
        if (userController.login())
            loggedInUpdateMenu();
    }

    private void loggedInUpdateMenu() {
        mainMenu.addMenuItem("4", "Check user info", this::displayCurrentUserInformation);
    }

    private ItemController pickItemType() {
        Runnable option = itemTypeSelection.showMenu();
        option.run();

        return getActiveItemController();
    }

    private void setupItemSelectionMenu() {
        itemTypeSelection = new Menu("\nPlease select the category of items you're interested in: ", "Please pick one of the above choices");
        itemTypeSelection.addMenuItem("1", "Books", () -> setActiveItemController(getBookController()));
        itemTypeSelection.addMenuItem("2", "Movie", () -> setActiveItemController(getMovieController()));
    }

    private void pickItemToCheckout() {
        BibliotecaItem checkedOutItem = pickItemType().pickItemToCheckout();

        if (checkedOutItem != null) {
            userController.currentUserChecksOut(checkedOutItem);
            System.out.println("Thank you! Please enjoy.");
        } else
            System.out.println("That item is not currently available.");
    }

    public void loginAsAdmin() {
        userController.loginAsAdmin();
        loggedInUpdateMenu();
    }

    private void setScanner(Scanner scanner) {
        sc = scanner;
    }

    public BookController getBookController() {
        return bookController;
    }

    public MovieController getMovieController() {
        return movieController;
    }

    public ItemController getActiveItemController() {
        return activeItemController;
    }

    private void setActiveItemController(ItemController activeItemController) {
        this.activeItemController = activeItemController;
    }

}
