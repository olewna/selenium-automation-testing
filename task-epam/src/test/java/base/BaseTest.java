package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.base.BasePage;
import org.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.pages.LoginPage;


public class BaseTest {
    public static WebDriver driver;
    @Before
    public void setUp() {
//        driver = DriverSingleton.getDriver("chrome");
        driver = DriverSingleton.getDriver("edge");
    }

    @After
    public void tearDown() {
        DriverSingleton.quitDriver();
    }
}
