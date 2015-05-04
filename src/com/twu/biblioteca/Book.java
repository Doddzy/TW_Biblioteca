package com.twu.biblioteca;

public class Book extends BibliotecaItem {
    private String author;

    public Book(String name, String author, int year) {
        super(name, year);
        this.author = author;
    }

    public String toString() {
        return super.toString() + ", Author: " + getAuthor();
    }


    public String getAuthor() {
        return author;
    }

}
