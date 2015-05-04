package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Claire on 4/05/15.
 */
public class Menu {
    private HashMap<String, MenuOption> menu;
    private Scanner sc;
    private String title, erorrMessage;


    public Menu(String message, String errorMessage) {
        title = message;
        this.erorrMessage = errorMessage;
        menu = new HashMap<String, MenuOption>();


    }

    public Runnable showMenu() {
        printMenu();
        try {
            return menu.get(sc.nextLine()).getFunction();
        } catch (Exception e) {
            System.out.println(erorrMessage);
            showMenu();
        }
        return null;
    }

    public void printMenu() {
        System.out.println(title);
        for (Map.Entry<String, MenuOption> option : menu.entrySet()) {
            System.out.println(option.getKey() + ": " + option.getValue().getDescription());
        }
    }

    public void setScanner(Scanner scanner) {
        this.sc = scanner;
    }

    public void addMenuItem(String key, String message, Runnable function) {
        menu.put(key, new MenuOption(message, function));
    }
}
