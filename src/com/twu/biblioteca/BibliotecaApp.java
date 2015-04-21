package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    public ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Movie> movieList = new ArrayList<Movie>();

    public BibliotecaApp() {

        addDefaultBooks();
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
        Scanner scannerInput = new Scanner(System.in);
        String input;
        System.out
                .println("Which of the following would you like to do? (1-4) ");
        System.out.println("1: List books");
        System.out.println("2: Checkout a book");
        System.out.println("3: Return a book");
        System.out.println("4: Quit");
        input = scannerInput.nextLine();
        switch (Integer.parseInt(input)) {
            case 1:
                printBookDetails();
                mainMenu();
                break;
            case 2:
                if (pickBookToCheckout())
                    System.out.println("Thank you! Enjoy the book.");
                else
                    System.out.println("That book is not available.");

                mainMenu();
                break;
            case 3:
                returnBook();
                mainMenu();
                break;
            case 4:
                printMovieDetails();
                mainMenu();
                break;
            case 5:
                if(pickMovieToCheckout())
                    System.out.println("Thank you! Enjoy the movie.");
                else
                    System.out.println("That movie is not available");
                break;
            case 6:
                System.out.println("Please enter your library number (xxx-xxxx)");
                System.out.println("Please enter password)");
                break;
            case 7:
                System.out.println("Thank you for using Biblioteca");
                break;
            default:
                System.out.println("Select a valid option!");
                mainMenu();

        }

    }

    /**TODO **/
    private boolean pickMovieToCheckout() {
        return false;
    }


    private void returnBook() {
        String name, author, year;
        try {
            Scanner sc = new Scanner(System.in);
            System.out
                    .println("Please enter the Name of the book you wish to return: ");
            name = sc.nextLine();
            System.out
                    .println("Please enter the Author of the book you wish to return: ");
            author = sc.nextLine();
            System.out
                    .println("Please enter the Year of Publication of the book you wish to return: ");
            year = sc.nextLine();
            addBook(name, author, Integer.parseInt(year));
            System.out.println("Thank you for returning the book.");
        } catch (Exception e) {
            System.out.println("That is not a valid book to return.");
        }

    }

    public void addBook(String name, String author, int year) {
        books.add(new Book(name, author, year));
    }

    public void addDefaultBooks() {
        addBook("Hello", "tom", 938);
        addBook("World", "horse", 18312);
        addBook("is", "Aidan", 19284);
        addBook("great", "Megan", 1999);
    }

    public void printBookDetails() {
        ArrayList<Book> books = getBookList();
        int curr = 1;
        for (Book book : books) {

            System.out.println(curr++ + ": " + book);
        }
    }

    public ArrayList<Book> getBookList() {
        return books;
    }

    public boolean pickBookToCheckout() {
        try {
            int input;
            Scanner sc = new Scanner(System.in);
            printBookDetails();
            System.out
                    .println("Please select the book number you wish to checkout");
            input = Integer.parseInt(sc.nextLine());
            Book book = getBookList().get(input - 1);
            return checkoutBook(book.getName(), book.getAuthor(),
                    book.getYear());
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkoutBook(String name, String author, int year) {
        ArrayList<Book> bookList = getBookList();
        int curr = 0;
        for (Book book : bookList) {

            if (book.getName().equals(name))
                if (book.getAuthor().equals(author))
                    if (book.getYear() == year) {
                        bookList.remove(curr);
                        return true;
                    }
            curr++;
        }
        return false;
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
}
