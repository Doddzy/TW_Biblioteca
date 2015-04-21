package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookControllerTests {

    private BookController bookController;

    @Before
    public void createBookController() {
        bookController = new BookController();
    }

    @Test
    public void testListBooksReturnsNonNull() {
        assertNotEquals(null, bookController.getBookList());
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
        assertEquals(expectedBooks.toString(), bookController.getBookList().toString());
    }

    @Test
    public void testAddBookCreatesNewBook() {
        int bookListSize = bookController.getBookList().size();
        bookController.addBook("new", "book", 7363);
        assertTrue(bookListSize < bookController.getBookList().size());
    }

    @Test
    public void testCheckoutBookRemovesABook() {
        int bookListSize = bookController.getBookList().size();
        bookController.checkoutBook("great", "Megan", 1999);
        assertTrue(bookListSize > bookController.getBookList().size());
    }

    @Test
    public void testCheckoutCanFail() {
        assertEquals(null, bookController.checkoutBook("fghfghfghfg", "Megan",
                1999));
    }

    @Test
    public void testCheckoutDoesNotRemovesABookOnFail() {
        int bookListSize = bookController.getBookList().size();
        bookController.checkoutBook("greatdsdad", "Megan", 1999);
        assertEquals(bookListSize, bookController.getBookList().size());
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
        bookController.checkoutBook("great", "Megan", 1999);
        assertEquals(expectedBooks.toString(), bookController.getBookList().toString());
    }
}
