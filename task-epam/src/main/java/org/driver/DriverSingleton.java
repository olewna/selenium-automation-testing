package org.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSingleton {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private DriverSingleton() {}

    public static WebDriver getDriver(String browser) {
        if (driver.get() == null) {
            WebDriver baseDriver;

            switch (browser.toLowerCase()) {
                case "chrome":
                    baseDriver = new ChromeDriver();
                    break;
                case "edge":
                    baseDriver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Wrong browser driver: " + browser);
            }
            driver.set(new WebDriverDecorator(baseDriver));
            driver.get().manage().window().maximize();
        }

        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
