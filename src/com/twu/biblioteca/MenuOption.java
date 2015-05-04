package com.twu.biblioteca;

/**
 * Created by Claire on 4/05/15.
 */
public class MenuOption {
    private Runnable function;

    private String description;

    public MenuOption(String description, Runnable function) {
        this.description = description;
        this.function = function;
    }

    public String getDescription() {
        return description;
    }

    public Runnable getFunction() {

        return function;
    }


}
