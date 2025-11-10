package org.pages;

import org.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private By usernameField = By.xpath("//input[@id='user-name']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By submitButton = By.xpath("//input[@id='login-button']");
    private By errorMessage = By.xpath("//div[@id='login_button_container']//h3");

    public void setUsernameField(String username) {
        set(usernameField, username);
    }

    public void setPasswordField(String password) {
        set(passwordField, password);
    }

    public void clearUsernameField() {
        WebElement field = driver.findElement(usernameField);
//        field.clear();

        field.click();
        field.sendKeys(Keys.CONTROL + "a");
        field.sendKeys(Keys.DELETE);
    }

    public void clearPasswordField() {
        WebElement field = driver.findElement(passwordField);
//        field.clear(); // not working for me

        field.click();
        field.sendKeys(Keys.CONTROL + "a");
        field.sendKeys(Keys.DELETE);
    }

    public String getErrorMsg() {
        return find(errorMessage).getText();
    }

    public HomePage clickSubmitButton() {
        click(submitButton);
        return new HomePage();
    }

    public HomePage login(String username, String password) {
        setUsernameField(username);
        setPasswordField(password);
        return clickSubmitButton();
    }
}
