package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MovieControllerTests {

    private MovieController movieController;

    @Before
    public void setupMovieController() {
        movieController = new MovieController();
    }

    @Test
    public void testListMoviesReturnsNonNull() {
        assertNotEquals(null, movieController.getMovieList());
    }

    @Test
    public void testListMoviesReturnsCorrectList() {
        ArrayList<Movie> expectedMovies = new ArrayList<Movie>() {
            {
                add(new Movie("MovieOne", 2001, "DirectorOne", 1));
                add(new Movie("MovieTwo", 2002, "DirectorTwo", 2));
                add(new Movie("MovieThree", 2003, "DirectorThree", 3));
                add(new Movie("MovieFour", 2004, "DirectorFour", 4));
            }
        };
        assertEquals(expectedMovies.toString(), movieController.getMovieList().toString());
    }


    @Test
    public void testCheckoutMovieRemovesAMovie() {
        int movieListSize = movieController.getMovieList().size();
        movieController.checkoutMovie("MovieOne", 2001, "DirectorOne", 1);
        assertTrue(movieListSize > movieController.getMovieList().size());
    }

    @Test
    public void testCheckoutCanFail() {
        assertEquals(null, movieController.checkoutMovie("fghfghfghfg", 12, "Megan",
                1999));
    }

    @Test
    public void testCheckoutDoesNotRemovesAMovieOnFail() {
        int movieListSize = movieController.getMovieList().size();
        movieController.checkoutMovie("greatdsdad", 12, "Megan", 1999);
        assertEquals(movieListSize, movieController.getMovieList().size());
    }

    @Test
    public void testCheckoutBookRemovesCorrectMovie() {
        ArrayList<Movie> expectedMovies = new ArrayList<Movie>() {
            {
                add(new Movie("MovieTwo", 2002, "DirectorTwo", 2));
                add(new Movie("MovieThree", 2003, "DirectorThree", 3));
                add(new Movie("MovieFour", 2004, "DirectorFour", 4));
            }
        };
        movieController.checkoutMovie("MovieOne", 2001, "DirectorOne", 1);
        assertEquals(expectedMovies.toString(), movieController.getMovieList().toString());
    }
}
