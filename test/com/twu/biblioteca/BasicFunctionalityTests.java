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
	public void testBookGetName()
	{
		assertEquals("Hello", new Book("Hello", "tom", 938).getName());
	}

	@Test
	public void testBookGetAuthor()
	{
		assertEquals("tom", new Book("Hello", "tom", 938).getAuthor());
	}

	@Test
	public void testBookGetYear()
	{
		assertEquals(938, new Book("Hello", "tom", 938).getYear());
	}

	@Test
	public void testBooktoString()
	{
		assertEquals("Name: Hello Author: tom Year published: 938\n", new Book(
				"Hello", "tom", 938).toString());
	}

	@Test
	public void testListBooksReturnsCorrectList()
	{
		ArrayList<Book> expectedBooks = new ArrayList<Book>()
		{
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
	public void testAddBookCreatesNewBook()
	{
		BibliotecaApp bib = new BibliotecaApp();
		int bookListSize = bib.getBookList().size();
		bib.addBook("new", "book", 7363);
		assertTrue(bookListSize < bib.getBookList().size());
	}
}
