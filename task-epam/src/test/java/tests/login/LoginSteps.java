package tests.login;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.models.User;
import org.openqa.selenium.WebDriver;
import org.pages.LoginPage;
import org.service.UserService;

public class LoginSteps {
    private WebDriver driver = BaseTest.driver;
    private LoginPage loginPage;
    private User userWithWrongCredentials = UserService.withWrongCredentials();

    @Given("User is on the login page {string}")
    public void userOnPage(String url) {
        driver.get(url);
        loginPage = new LoginPage();
        loginPage.setDriver(driver);
    }



    @When("User types credentials into fields and deletes only password field")
    public void typeCredentialsAndDeleteUsername(){
        loginPage.setUsernameField(userWithWrongCredentials.getUsername());
        loginPage.setPasswordField(userWithWrongCredentials.getPassword());

        loginPage.clearPasswordField();
    }

    @When("User writes wrong credentials")
    public void writeWrongCredentials() {
        loginPage.setUsernameField(userWithWrongCredentials.getUsername());
        loginPage.setPasswordField(userWithWrongCredentials.getPassword());
    }

    @When("User deletes credentials")
    public void deleteCredentials() {
        loginPage.clearUsernameField();
        loginPage.clearPasswordField();
    }

    @When("User clicks login button")
    public void clickLoginButton(){
        loginPage.clickSubmitButton();
    }



    @Then("Error message should contain {string}")
    public void verifyErrorMsg(String expected) {
        String actualMsg = loginPage.getErrorMsg();

        Assertions.assertTrue(actualMsg.contains(expected));
    }
}
