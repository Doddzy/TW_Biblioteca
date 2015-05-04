package com.twu.biblioteca;


public class Movie extends BibliotecaItem {
    private String director;
    private int rating;


    public Movie(String name, int year, String director, int rating) {
        super(name, year);
        this.director = director;
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }


    public int getRating() {
        return rating;
    }


    public String toString() {
        return super.toString() + ", Director: " + getDirector() + ", Rating: " + getRating();
    }
}
