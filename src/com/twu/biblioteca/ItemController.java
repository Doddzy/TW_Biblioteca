package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by Claire on 4/05/15.
 */
public abstract class ItemController {
    public abstract void printAvailable();

    public abstract BibliotecaItem pickItemToCheckout();

    public abstract void setScanner(Scanner sc);

    public abstract void addDefaultItems();

    public abstract void returnItem();
}
