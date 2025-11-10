package tests.home;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.models.User;
import org.pages.HomePage;
import org.service.UserService;

public class HomeTests extends BaseTest {
    private User userCorrect = UserService.withCredentialsFromProperty();

    @Test
    public void testLoginWithCredentials() {
        HomePage homePage = loginPage.login(userCorrect.getUsername(), userCorrect.getPassword());

        String actualTitle = homePage.getDashboardTitle();

        Assertions.assertTrue(actualTitle.contains("Swag Labs"));
    }
}
