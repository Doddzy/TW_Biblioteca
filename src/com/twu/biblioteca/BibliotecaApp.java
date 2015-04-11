package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp
{
	public ArrayList<String> books = new ArrayList<String>();

	public BibliotecaApp()
	{

		addDefaultBooks();
	}

	public static void main(String[] args)
	{
		BibliotecaApp bib = new BibliotecaApp();
		System.out.println(bib.getWelcomeMessage());
	}

	public String getWelcomeMessage()
	{
		return "Welcome to Biblioteca";
	}

	public ArrayList<String> getBookList()
	{
		return books;
	}

	public void addBook(String name)
	{
		books.add(name);
	}

	public void addDefaultBooks()
	{
		addBook("Hello");
		addBook("World");
		addBook("is");
		addBook("great");
	}
}
