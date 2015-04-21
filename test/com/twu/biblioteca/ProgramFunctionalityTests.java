package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProgramFunctionalityTests {

    public BibliotecaApp bib;

    @Before
    public void createNewBibliotecaInstance() {
        bib = new BibliotecaApp();
        bib.loginAsAdmin();
    }

    @Test
    public void testJUnit() {
        assertEquals(1, 1);
    }

    @Test
    public void testWelcomeMessageExists() {
        assertEquals("Welcome to Biblioteca",
                bib.getWelcomeMessage());
    }

}
