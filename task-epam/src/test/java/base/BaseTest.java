package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseTest {
    public static WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @Before
    public void setUp() {
//        driver = DriverSingleton.getDriver("chrome");
//        driver = DriverSingleton.getDriver("edge");
        String browser = System.getProperty("browser", "chrome");
        log.info("Starting browser: {}", browser);
        driver = DriverSingleton.getDriver(browser);
    }

    @After
    public void tearDown() {
        log.info("Closing browser");
        DriverSingleton.quitDriver();
    }
}
