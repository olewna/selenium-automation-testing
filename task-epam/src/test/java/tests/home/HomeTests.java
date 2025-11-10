package tests.home;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pages.HomePage;

public class HomeTests extends BaseTest {
    private String correctUsername = "performance_glitch_user";
    private String correctPassword = "secret_sauce";

    @Test
    public void testLoginWithCredentials() {
        HomePage homePage = loginPage.login(correctUsername, correctPassword);

        String actualTitle = homePage.getDashboardTitle();

        Assertions.assertTrue(actualTitle.contains("Swag Labs"));
    }
}
