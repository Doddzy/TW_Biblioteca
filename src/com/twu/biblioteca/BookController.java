package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BookController extends ItemController {
    private ArrayList<Book> books;
    private Scanner sc;

    public BookController() {
        books = new ArrayList<Book>();
        addDefaultItems();
       
    }

    public void addBook(String name, String author, int year) {
        books.add(new Book(name, author, year));
    }

    public void printAvailable() {
        ArrayList<Book> books = getBookList();
        int curr = 1;
        System.out.println();
        for (Book book : books) {

            System.out.println(curr++ + ": " + book);
        }
    }

    public ArrayList<Book> getBookList() {
        return books;
    }

    public Book pickItemToCheckout() {
        try {
            int input;
            printAvailable();
            System.out
                    .println("Please select the book number you wish to checkout");
            input = Integer.parseInt(sc.nextLine());
            Book book = getBookList().get(input - 1);
            return checkoutBook(book.getName(), book.getAuthor(),
                    book.getYear());
        } catch (Exception e) {
            return null;
        }
    }

    public Book checkoutBook(String name, String author, int year) {
        ArrayList<Book> bookList = getBookList();
        int curr = 0;
        for (Book book : bookList) {

            if (book.getName().equals(name))
                if (book.getAuthor().equals(author))
                    if (book.getYear() == year) {
                        bookList.remove(curr);
                        return book;
                    }
            curr++;
        }
        return null;
    }

    public void returnItem() {
        String name, author, year;
        try {
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

    public void addDefaultItems() {
        addBook("Hello", "tom", 938);
        addBook("World", "horse", 18312);
        addBook("is", "Aidan", 19284);
        addBook("great", "Megan", 1999);
    }

    public void setScanner(Scanner scanner) {
        this.sc = scanner;
    }
}

