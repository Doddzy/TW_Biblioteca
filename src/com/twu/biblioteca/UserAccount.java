package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by user on 22-04-15.
 */
public class UserAccount {
    String id, password, name, email, phone;

    ArrayList<BibliotecaItem> currentlyCheckedOut;

    public UserAccount(String id, String password, String name, String email, String phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;

        currentlyCheckedOut = new ArrayList<BibliotecaItem>();
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String toString() {
        return "ID: " + getId() + ", Name: " + getName() + ", Email: " + getEmail() + ", Phone: " + getPhone();
    }

    public ArrayList<BibliotecaItem> getCurrentlyCheckedOut() {
        return currentlyCheckedOut;
    }

    public void checkoutItem(BibliotecaItem item) {
        currentlyCheckedOut.add((item));
    }
}
