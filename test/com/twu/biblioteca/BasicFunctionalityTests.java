package com.twu.biblioteca;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class BasicFunctionalityTests
{

	@Test
	public void testJUnit()
	{
		assertEquals(1, 1);
	}

	@Test
	public void testWelcomeMessageExists()
	{
		assertEquals("Welcome to Biblioteca",
				new BibliotecaApp().getWelcomeMessage());
	}

	@Test
	public void testListBooksReturnsNonNull()
	{
		assertNotEquals(null, new BibliotecaApp().getBookList());
	}

	@Test
	public void testListBooksReturnsCorrectList()
	{
		ArrayList<String> expectedBooks = new ArrayList<String>()
		{
			{
				add("Hello");
				add("World");
				add("is");
				add("great");
			}
		};

		assertEquals(expectedBooks, new BibliotecaApp().getBookList());
	}

	@Test
	public void testAddBookCreatesNewBook()
	{
		BibliotecaApp bib = new BibliotecaApp();
		int bookListSize = bib.getBookList().size();
		bib.addBook("new");
		assertTrue(bookListSize < bib.getBookList().size());
	}
}
