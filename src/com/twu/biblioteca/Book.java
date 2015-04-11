package com.twu.biblioteca;

public class Book
{
	public String name, author;
	public int year;

	public Book(String name, String author, int year)
	{
		this.name = name;
		this.author = author;
		this.year = year;
	}

	public String toString()
	{
		return "Name: " + getName() + " Author: " + getAuthor()
				+ " Year published: " + getYear() + "\n";
	}

	public String getName()
	{
		return name;
	}

	public String getAuthor()
	{
		return author;
	}

	public int getYear()
	{
		return year;
	}
}
