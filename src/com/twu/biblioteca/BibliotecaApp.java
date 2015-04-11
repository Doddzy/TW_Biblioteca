package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp
{
	public ArrayList<Book> books = new ArrayList<Book>();

	public BibliotecaApp()
	{

		addDefaultBooks();

	}

	public static void main(String[] args)
	{
		BibliotecaApp bib = new BibliotecaApp();
		System.out.println(bib.getWelcomeMessage());
		bib.showMainMenu();
	}

	public String getWelcomeMessage()
	{
		return "Welcome to Biblioteca";
	}

	private void showMainMenu()
	{
		System.out.println("Which of the following would you like to do? ");
		System.out.println("1: List books");

	}

	public ArrayList<Book> getBookList()
	{
		return books;
	}

	public void addBook(String name, String author, int year)
	{
		books.add(new Book(name, author, year));
	}

	public void addDefaultBooks()
	{
		addBook("Hello", "tom", 938);
		addBook("World", "horse", 18312);
		addBook("is", "Aidan", 19284);
		addBook("great", "Megan", 1999);
	}

	public void printBookDetails()
	{
		ArrayList<Book> books = getBookList();
		for (Book book : books)
		{
			System.out.println(book);
		}
	}
}
