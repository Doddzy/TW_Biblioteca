package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private ArrayList<Movie> movieList;
    private Scanner sc;
    private UserAccountController userController;
    private BookController bookController;

    public BibliotecaApp() {

        movieList = new ArrayList<Movie>();
        bookController = new BookController();
        userController = new UserAccountController();
        sc = new Scanner(System.in);


        addDefaultMovies();
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
        String input;
        boolean quit = false;
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
        input = sc.nextLine();
        switch (Integer.parseInt(input)) {
            case 1:
                switch (pickBookOrMovie()) {
                    case Book.ITEM_TYPE:
                        bookController.printAllBookDetails();
                        break;
                    case Movie.ITEM_TYPE:
                        printMovieDetails();
                        break;
                }
                break;
            case 2:
                if (userController.checkIfLoggedIn())
                    if (requestLoginAttempt("This option requires you to be logged in"))
                        login();

                if (userController.checkIfLoggedIn())
                    pickItemToCheckout();
                break;
            case 3:
                if (userController.checkIfLoggedIn())
                    if (requestLoginAttempt("This option requires you to be logged in"))
                        login();

                if (userController.checkIfLoggedIn())
                    bookController.returnBook();
                break;
            case 4:
                if (userController.checkIfLoggedIn())
                    login();
                else
                    displayCurrentUserInformation();
                break;
            case 6:
                System.out.println("Thank you for using Biblioteca");
                quit = true;
                break;
            default:
                System.out.println("Select a valid option!");

        }
        if (!quit)
            mainMenu();

    }

    public void checkoutBook(String name, String author, int year) {
        Book checkedoutBook = bookController.checkoutBook(name, author, year);
        if (checkedoutBook != null)
            userController.getCurrentUser().checkoutItem(checkedoutBook);
    }

    private void displayCurrentUserInformation() {
        System.out.println(userController.getCurrentUser());
    }

    private void login() {
        String userInputID, userInputPassword;

        userInputID = getUserInput("Please enter your library number (xxx-xxxx)");
        userInputPassword = getUserInput("Please enter your password");

        userController.loginAttemptWithCredentials(userInputID, userInputPassword);

        if (userController.checkIfLoggedIn()) {
            if (requestLoginAttempt("Login failed"))
                login();
        } else
            System.out.println("Successfully logged in as " + userController.getCurrentUser());
    }

    private boolean requestLoginAttempt(String message) {
        System.out.println(message + ", would you like to login? (Y/N)");
        String retry = sc.nextLine();
        if (retry.equalsIgnoreCase("y"))
            return true;
        return false;
    }


    private String getUserInput(String message) {
        System.out.println(message);
        return sc.nextLine();
    }

    private int pickBookOrMovie() {
        try {
            System.out.println("Please select the category of items you're interested in: ");
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
                //checkedOutItem = pickMovieToCheckout();
                break;
        }
        if (checkedOutItem != null)
            System.out.println("Thank you! Please enjoy.");
        else
            System.out.println("That item is not currently available.");
    }


    private void addDefaultMovies() {
        movieList.add(new Movie("MovieOne", 2001, "DirectorOne", 1));
        movieList.add(new Movie("MovieTwo", 2002, "DirectorTwo", 2));
        movieList.add(new Movie("MovieThree", 2003, "DirectorThree", 3));
        movieList.add(new Movie("MovieFour", 2004, "DirectorFour", 4));
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    private void printMovieDetails() {
        int curr = 1;

        for (Movie movie : getMovieList())
            System.out.println(curr++ + ": " + movie);
    }

    private boolean pickMovieToCheckout() {
        try {
            int input;
            printMovieDetails();
            System.out
                    .println("Please select the movie number you wish to checkout");
            input = Integer.parseInt(sc.nextLine());
            Movie movie = getMovieList().get(input - 1);
            return checkoutMovie(movie.getName(), movie.getYear(), movie.getDirector(),
                    movie.getRating());
        } catch (Exception e) {
            return false;
        }
    }

    private boolean checkoutMovie(String name, int year, String director, int rating) {
        ArrayList<Movie> movieList = getMovieList();
        int curr = 0;
        for (Movie movie : movieList) {

            if (movie.getName().equals(name) && movie.getDirector().equals(director) && movie.getRating() == rating && movie.getYear() == year) {
                movieList.remove(curr);
                return true;
            }
            curr++;
        }


        return false;
    }


    public void loginAsAdmin() {
        userController.loginAsAdmin();
    }
}
