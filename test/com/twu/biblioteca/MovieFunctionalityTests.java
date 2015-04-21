package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieFunctionalityTests {
    Movie testMovie;

    @Test
    public void testJUnit() {
        assertEquals(1, 1);
    }

    @Before
    public void setupBasicTestMovie() {
        testMovie = new Movie("MovieOne", 2015, "Aidan", 10);
    }

    @Test
    public void testMovieGetName() {
        assertEquals("MovieOne", testMovie.getName());
    }

    @Test
    public void testMovieGetYear() {
        assertEquals(2015, testMovie.getYear());
    }

    @Test
    public void testMovieGetDirector() {
        assertEquals("Aidan", testMovie.getDirector());
    }

    @Test
    public void testMovieGetRating() {
        assertEquals(10, testMovie.getRating());
    }

    @Test
    public void testMovietoString() {
        assertEquals("Name: MovieOne, Year: 2015, Director: Aidan, Rating: 10", testMovie.toString());
    }


}
