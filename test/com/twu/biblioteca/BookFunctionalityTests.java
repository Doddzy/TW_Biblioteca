package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookFunctionalityTests {
    @Test
    public void testJUnit() {
        assertEquals(1, 1);
    }

    @Test
    public void testBookGetName() {
        assertEquals("Hello", new Book("Hello", "tom", 938).getName());
    }

    @Test
    public void testBookGetAuthor() {
        assertEquals("tom", new Book("Hello", "tom", 938).getAuthor());
    }

    @Test
    public void testBookGetYear() {
        assertEquals(938, new Book("Hello", "tom", 938).getYear());
    }

    @Test
    public void testBooktoString() {
        assertEquals("Name: Hello, Year: 938, Author: tom", new Book(
                "Hello", "tom", 938).toString());
    }
}
