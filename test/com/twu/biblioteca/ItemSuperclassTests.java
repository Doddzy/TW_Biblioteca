package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemSuperclassTests {

    @Test
    public void testJUnit() {
        assertEquals(1, 1);
    }
    @Test
    public void testItemNameGetterForMovie(){
        assertEquals("MovieOne",new Movie("MovieOne",2001,"DirectorOne",1).getName());
    }
}
