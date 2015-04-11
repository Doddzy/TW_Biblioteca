package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

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
		bib.mainMenu();
	}

	public String getWelcomeMessage()
	{
		return "Welcome to Biblioteca";
	}

	private void mainMenu()
	{
		Scanner scannerInput = new Scanner(System.in);
		String input;
		System.out
				.println("Which of the following would you like to do? (1-4) ");
		System.out.println("1: List books");
		System.out.println("2: Checkout a book");
		System.out.println("3: Return a book");
		System.out.println("4: Quit");
		input = scannerInput.nextLine();
		switch (Integer.parseInt(input))
		{
		case 1:
			printBookDetails();
			mainMenu();
			break;
		case 2:
			if (pickBookToCheckout())
				System.out.println("Thank you! Enjoy the book.");
			else
				System.out.println("That book is not available.");

			mainMenu();
			break;
		case 3:
			printBookDetails();
			mainMenu();
			break;
		case 4:
			break;
		default:
			System.out.println("Select a valid option!");
			mainMenu();

		}

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
		int curr = 1;
		for (Book book : books)
		{

			System.out.println(curr++ + ": " + book);
		}
	}

	public ArrayList<Book> getBookList()
	{
		return books;
	}

	public boolean pickBookToCheckout()
	{
		int input;
		Scanner sc = new Scanner(System.in);
		printBookDetails();
		System.out
				.println("Please select the book number you wish to checkout");
		input = Integer.parseInt(sc.nextLine());
		Book book = getBookList().get(input);
		return checkoutBook(book.getName(), book.getAuthor(), book.getYear());
	}

	public boolean checkoutBook(String name, String author, int year)
	{
		ArrayList<Book> bookList = getBookList();
		for (Book book : bookList)
		{
			if (book.getName().equals(name))
				if (book.getAuthor().equals(author))
					if (book.getYear() == year)
					{
						bookList.remove(book);
						return true;
					}
		}
		return false;
	}
}
