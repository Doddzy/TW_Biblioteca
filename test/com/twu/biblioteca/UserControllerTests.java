package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by user on 22-04-15.
 */
public class UserControllerTests {
    UserAccountController userController;

    @Before
    public void createUserController() {
        userController = new UserAccountController();
    }

    @Test
    public void testListUsersReturnsNonNull() {
        assertNotEquals(null, userController.getUserList());
    }

    @Test
    public void testListUsersReturnsCorrectList() {
        ArrayList<UserAccount> expectedUsers = new ArrayList<UserAccount>() {
            {
                add(new UserAccount("123-4567", "passwordOne", "NameOne", "EmailOne", "phoneOne"));
                add(new UserAccount("223-4567", "passwordTwo", "NameTwo", "EmailTwo", "phoneTwo"));
                add(new UserAccount("323-4567", "passwordThree", "NameThree", "EmailThree", "phoneThree"));
                add(new UserAccount("423-4567", "passwordFour", "NameFour", "EmailFour", "phoneFour"));
            }
        };
        assertEquals(expectedUsers.toString(), userController.getUserList().toString());
    }
}
