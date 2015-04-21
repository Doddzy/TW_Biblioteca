package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProgramFunctionalityTests {

    @Test
    public void testJUnit() {
        assertEquals(1, 1);
    }

    @Test
    public void testWelcomeMessageExists() {
        assertEquals("Welcome to Biblioteca",
                new BibliotecaApp().getWelcomeMessage());
    }

    @Test
    public void testListBooksReturnsNonNull() {
        assertNotEquals(null, new BibliotecaApp().getBookList());
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
        assertEquals(expectedBooks.toString(), new BibliotecaApp()
                .getBookList().toString());
    }

    @Test
    public void testAddBookCreatesNewBook() {
        BibliotecaApp bib = new BibliotecaApp();
        int bookListSize = bib.getBookList().size();
        bib.addBook("new", "book", 7363);
        assertTrue(bookListSize < bib.getBookList().size());
    }

    @Test
    public void testCheckoutBookRemovesABook() {
        BibliotecaApp bib = new BibliotecaApp();
        int bookListSize = bib.getBookList().size();
        bib.checkoutBook("great", "Megan", 1999);
        assertTrue(bookListSize > bib.getBookList().size());
    }

    @Test
    public void testCheckoutCanFail() {
        assertFalse(new BibliotecaApp().checkoutBook("fghfghfghfg", "Megan",
                1999));
    }

    @Test
    public void testCheckoutDoesNotRemovesABookOnFail() {
        BibliotecaApp bib = new BibliotecaApp();
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
        BibliotecaApp bib = new BibliotecaApp();
        bib.checkoutBook("great", "Megan", 1999);
        assertEquals(expectedBooks.toString(), bib.getBookList().toString());
    }
}
