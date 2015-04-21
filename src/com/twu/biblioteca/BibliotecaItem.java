package com.twu.biblioteca;

public class BibliotecaItem {


    private String name;
    private int year;

    public BibliotecaItem(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Name: " + getName() + ", Year: " + getYear();
    }

}
