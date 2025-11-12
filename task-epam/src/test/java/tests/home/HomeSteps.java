package tests.home;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.models.User;
import org.openqa.selenium.WebDriver;
import org.pages.HomePage;
import org.pages.LoginPage;
import org.service.UserService;

public class HomeSteps {
    private WebDriver driver = BaseTest.driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private String actualTitle;

    @Given("User logs on {string} with username {string} and password {string}")
    public void logIn(String url, String username, String password) {
        driver.get(url);
        loginPage = new LoginPage();
        loginPage.setDriver(driver);

        User userCorrect = UserService.withCredentialsFromProperty(username, password);

        homePage = loginPage.login(userCorrect.getUsername(), userCorrect.getPassword());
    }

    @When("Homepage is loaded")
    public void getDashboardTitle() {
        actualTitle = homePage.getDashboardTitle();
    }

    @Then("Dashboard title should be {string}")
    public void verifyDashboardTitle(String expectedTitle) {
        Assertions.assertTrue(actualTitle.contains(expectedTitle));
    }
}
