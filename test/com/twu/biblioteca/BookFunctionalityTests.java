package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookFunctionalityTests {
    Book book;

    @Before
    public void createBasicTestingBook() {
        book = new Book("Hello", "tom", 938);
    }

    @Test
    public void testJUnit() {
        assertEquals(1, 1);
    }

    @Test
    public void testBookGetName() {
        assertEquals("Hello", book.getName());
    }

    @Test
    public void testBookGetAuthor() {
        assertEquals("tom", book.getAuthor());
    }

    @Test
    public void testBookGetYear() {
        assertEquals(938, book.getYear());
    }

    @Test
    public void testBooktoString() {
        assertEquals("Name: Hello, Year: 938, Author: tom", book.toString());
    }
}
