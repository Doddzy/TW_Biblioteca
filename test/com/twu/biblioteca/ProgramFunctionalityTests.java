package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProgramFunctionalityTests {

    public  BibliotecaApp bib;

    @Before
    public void createNewBibliotecaInstance() {
        bib = new BibliotecaApp();
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
    public void testListBooksReturnsNonNull() {
        assertNotEquals(null, bib.getBookList());
    }

    @Test
    public void testListBooksReturnsCorrectList() {
        ArrayList<Book> expectedBooks = new ArrayList<Book>() {
            {
                add(new Book("Hello", "tom", 938));
                add(new Book("World", "horse", 18312));
                add(new Book("is", "Aidan", 19284));
                add(new Book("great", "Megan", 1999));
            }
        };
        assertEquals(expectedBooks.toString(), bib.getBookList().toString());
    }

    @Test
    public void testAddBookCreatesNewBook() {
        int bookListSize = bib.getBookList().size();
        bib.addBook("new", "book", 7363);
        assertTrue(bookListSize < bib.getBookList().size());
    }

    @Test
    public void testCheckoutBookRemovesABook() {
        int bookListSize = bib.getBookList().size();
        bib.checkoutBook("great", "Megan", 1999);
        assertTrue(bookListSize > bib.getBookList().size());
    }

    @Test
    public void testCheckoutCanFail() {
        assertFalse(bib.checkoutBook("fghfghfghfg", "Megan",
                1999));
    }

    @Test
    public void testCheckoutDoesNotRemovesABookOnFail() {
        int bookListSize = bib.getBookList().size();
        bib.checkoutBook("greatdsdad", "Megan", 1999);
        assertEquals(bookListSize, bib.getBookList().size());
    }

    @Test
    public void testCheckoutBookRemovesCorrectBook() {
        ArrayList<Book> expectedBooks = new ArrayList<Book>() {
            {
                add(new Book("Hello", "tom", 938));
                add(new Book("World", "horse", 18312));
                add(new Book("is", "Aidan", 19284));
            }
        };
        bib.checkoutBook("great", "Megan", 1999);
        assertEquals(expectedBooks.toString(), bib.getBookList().toString());
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
