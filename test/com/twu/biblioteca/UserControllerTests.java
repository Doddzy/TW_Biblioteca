package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
                add(new UserAccount("111-1111", "password", "testName", "testEmail", "testPhoneNumber"));
                add(new UserAccount("123-4567", "passwordOne", "NameOne", "EmailOne", "phoneOne"));
                add(new UserAccount("223-4567", "passwordTwo", "NameTwo", "EmailTwo", "phoneTwo"));
                add(new UserAccount("323-4567", "passwordThree", "NameThree", "EmailThree", "phoneThree"));
                add(new UserAccount("423-4567", "passwordFour", "NameFour", "EmailFour", "phoneFour"));
            }
        };
        assertEquals(expectedUsers.toString(), userController.getUserList().toString());
    }

    @Test
    public void testLoginAsAdmin() {
        userController.loginAsAdmin();
        assertEquals(new UserAccount("000-0000", "admin", "admin", "admin@admin.com", "9999 9999").toString(), userController.getCurrentUser().toString());
    }
    @Test
    public void testLoginFunctions(){
        userController.loginAttemptWithCredentials("123-4567", "passwordOne");

        assertEquals(new UserAccount("123-4567", "passwordOne", "NameOne", "EmailOne", "phoneOne").toString(),userController.getCurrentUser().toString());
    }

    @Test
    public void testLoginChecksCredentials(){
        userController.loginAttemptWithCredentials("123-4567","passwordOne");

        assertNotEquals(new UserAccount("14332457", "passwordOne", "NameOne", "EmailOne", "phoneOne").toString(), userController.getCurrentUser().toString());
    }

    @Test
    public void testCheckIfLoggedInStartsOffFalse(){
        assertEquals(false, userController.checkIfLoggedIn());
    }
    @Test
    public void testCheckIfLoggedInIsChanging(){
        userController.loginAttemptWithCredentials("123-4567", "passwordOne");
        assertEquals(true,userController.checkIfLoggedIn());
    }
}
