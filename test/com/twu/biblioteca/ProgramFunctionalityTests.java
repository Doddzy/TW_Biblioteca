package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ProgramFunctionalityTests {

    public BibliotecaApp bib;

    @Before
    public void createNewBibliotecaInstance() {
        bib = new BibliotecaApp();
        bib.loginAsAdmin();
    }

    @Test
    public void testJUnit() {
        assertEquals(1, 1);
    }

    @Test
    public void testWelcomeMessageExists() {
        assertEquals("Welcome to Biblioteca",
                bib.getWelcomeMessage());
    }



    @Test
    public void testListMoviesReturnsNonNull() {
        assertNotEquals(null, bib.getMovieList());
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
        assertEquals(expectedMovies.toString(), bib.getMovieList().toString());
    }


}
