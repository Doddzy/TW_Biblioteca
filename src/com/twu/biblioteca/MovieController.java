package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieController {
    private ArrayList<Movie> movieList;
    private Scanner sc;

    public MovieController() {
        movieList = new ArrayList<Movie>();
        sc = new Scanner(System.in);
        addDefaultMovies();
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

    public void printMovieDetails() {
        int curr = 1;
        System.out.println();
        for (Movie movie : getMovieList())
            System.out.println(curr++ + ": " + movie);
    }

    public Movie pickMovieToCheckout() {
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
            return null;
        }
    }

    public Movie checkoutMovie(String name, int year, String director, int rating) {
        ArrayList<Movie> movieList = getMovieList();
        int curr = 0;
        for (Movie movie : movieList) {
            if (movie.getName().equals(name) && movie.getDirector().equals(director) && movie.getRating() == rating && movie.getYear() == year) {
                movieList.remove(curr);
                return movie;
            }
            curr++;
        }
        return null;
    }
}
