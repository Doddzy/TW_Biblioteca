package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class ItemSuperclassTests {

    @Test
    public void testJUnit() {
        assertEquals(1, 1);
    }

    @Test
    public void testItemNameGetterForMovie() {
        assertEquals("MovieOne", new Movie("MovieOne", 2001, "DirectorOne", 1).getName());
    }

    @Test
    public void testItemYearGetterForMovie() {
        assertEquals(2001, new Movie("MovieOne", 2001, "DirectorOne", 1).getYear());
    }

    @Test
    public void testItemNameGetterForBook() {
        assertEquals("BookOne", new Book("BookOne", "AuthorOne", 1991).getName());
    }

    @Test
    public void testItemYearGetterForBook() {
        assertEquals(1991, new Book("BookOne", "AuthorOne", 1991).getYear());
    }
}
