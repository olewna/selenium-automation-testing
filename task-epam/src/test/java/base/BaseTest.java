package base;

import org.base.BasePage;
import org.driver.DriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.pages.LoginPage;


public class BaseTest {

    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    private String url = "https://www.saucedemo.com/";

    @BeforeEach
    public void setUp() {
//        driver = DriverSingleton.getDriver("chrome");
        driver = DriverSingleton.getDriver("edge");

        driver.get(url);

        basePage = new BasePage();
        basePage.setDriver(driver);

        loginPage = new LoginPage();
    }

    @AfterEach
    public void tearDown() {
        DriverSingleton.quitDriver();
    }
}
