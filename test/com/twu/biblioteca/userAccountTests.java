package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class userAccountTests {
    UserAccount testUser;

    @Test
    public void testJUnit() {
        assertEquals(1, 1);
    }

    @Before
    public void createTestUserAccount() {
        testUser = new UserAccount("123-4567", "password", "NameOne", "EmailOne", "phoneOne");
    }

    @Test
    public void testGetUserID() {
        assertEquals("123-4567", testUser.getId());
    }

    @Test
    public void testGetUserPassword() {
        assertEquals("password", testUser.getPassword());
    }

    @Test
    public void testGetUserName() {
        assertEquals("NameOne", testUser.getName());
    }

    @Test
    public void testGetUserEmail() {
        assertEquals("EmailOne", testUser.getEmail());
    }

    @Test
    public void testGetUserPhone() {
        assertEquals("phoneOne", testUser.getPhone());
    }

    @Test
    public void testGetCurrentlyCheckedOutIsEmpty() {
        assertEquals(new ArrayList<BibliotecaItem>(), testUser.getCurrentlyCheckedOut());
    }

    @Test
    public void testCheckoutBookItem() {
        ArrayList<BibliotecaItem> expectedResult = new ArrayList<BibliotecaItem>();
        Book bookToBeAdded = new Book("BookOne", "AuthorOne", 2001);
        expectedResult.add(bookToBeAdded);
        testUser.checkoutItem(bookToBeAdded);
        assertEquals(expectedResult, testUser.getCurrentlyCheckedOut());
    }
    @Test
    public void testCheckoutMovieItem() {
        ArrayList<BibliotecaItem> expectedResult = new ArrayList<BibliotecaItem>();
        Movie movieToBeAdded = new Movie("MovieOne",2001, "DirectorOne", 1);
        expectedResult.add(movieToBeAdded);
        testUser.checkoutItem(movieToBeAdded);
        assertEquals(expectedResult, testUser.getCurrentlyCheckedOut());
    }

}
