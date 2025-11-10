package tests.login;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.models.User;
import org.service.UserService;

public class LoginTests extends BaseTest {
    private User userWithWrongCredentials = UserService.withWrongCredentials();
    @Test
    public void testLoginWithEmptyCredentials() {
        loginPage.setUsernameField(userWithWrongCredentials.getUsername());
        loginPage.setPasswordField(userWithWrongCredentials.getPassword());

        loginPage.clearUsernameField();
        loginPage.clearPasswordField();

        loginPage.clickSubmitButton();

        String actualMsg = loginPage.getErrorMsg();

        Assertions.assertTrue(actualMsg.contains("Username is required"));
    }

    @Test
    public void testLoginWithOnlyUsername() {
        loginPage.setUsernameField(userWithWrongCredentials.getUsername());
        loginPage.setPasswordField(userWithWrongCredentials.getPassword());

        loginPage.clearPasswordField();

        loginPage.clickSubmitButton();

        String actualMsg = loginPage.getErrorMsg();

        Assertions.assertTrue(actualMsg.contains("Password is required"));
    }
}
