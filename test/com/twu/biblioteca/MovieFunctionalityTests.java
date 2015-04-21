package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieFunctionalityTests {
    @Test
    public void testJUnit() {
        assertEquals(1, 1);
    }

    @Test
    public void testMovieGetName() {
        assertEquals("MovieOne", new Movie("MovieOne", 2015, "Aidan", 10).getName());
    }

    @Test
    public void testMovieGetYear() {
        assertEquals(2015, new Movie("MovieOne", 2015, "Aidan", 10).getYear());
    }

    @Test
    public void testMovieGetDirector() {
        assertEquals("Aidan", new Movie("MovieOne", 2015, "Aidan", 10).getDirector());
    }

    @Test
    public void testMovieGetRating() {
        assertEquals(10, new Movie("MovieOne", 2015, "Aidan", 10).getRating());
    }

    @Test
    public void testMovietoString() {
        assertEquals("Name: MovieOne, Year: 2015, Director: Aidan, Rating: 10", new Movie("MovieOne", 2015, "Aidan", 10).toString());
    }


}
