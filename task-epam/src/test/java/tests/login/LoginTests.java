package tests.login;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginWithEmptyCredentials() {
        loginPage.setUsernameField("anyCredential");
        loginPage.setPasswordField("anyCredential");

        loginPage.clearUsernameField();
        loginPage.clearPasswordField();

        loginPage.clickSubmitButton();

        String actualMsg = loginPage.getErrorMsg();

        Assertions.assertTrue(actualMsg.contains("Username is required"));
    }

    @Test
    public void testLoginWithOnlyUsername() {
        loginPage.setUsernameField("anyCredential");
        loginPage.setPasswordField("anyCredential");

        loginPage.clearPasswordField();

        loginPage.clickSubmitButton();

        String actualMsg = loginPage.getErrorMsg();

        Assertions.assertTrue(actualMsg.contains("Password is required"));
    }
}
