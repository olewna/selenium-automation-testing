package org.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

public class WebDriverDecorator implements WebDriver {
    private final WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(WebDriverDecorator.class);

    public WebDriverDecorator(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void get(String url) {
        log.info("Navigating to URL: {}", url);
        driver.get(url);
    }

    @Override
    public String getTitle() {
        String title = driver.getTitle();
        log.info("Page title is: {}", title);
        return title;
    }

    @Override
    public void close() {
        log.info("Closing current window");
        driver.close();
    }

    @Override
    public void quit() {
        log.info("Quitting browser");
        driver.quit();
    }

    @Override
    public WebElement findElement(By by) {
        log.info("Finding element: {}", by);
        WebElement element = driver.findElement(by);
        return new WebElementDecorator(element);
    }

    @Override
    public List<WebElement> findElements(By by) {
        log.info("Finding elements: {}", by);
        List<WebElement> elements = driver.findElements(by);
        return elements;
    }
    @Override public String getCurrentUrl() { return driver.getCurrentUrl(); }
    @Override public String getPageSource() { return driver.getPageSource(); }
    @Override public Navigation navigate() { return driver.navigate(); }
    @Override public Options manage() { return driver.manage(); }
    @Override public TargetLocator switchTo() { return driver.switchTo(); }
    @Override public Set<String> getWindowHandles() { return driver.getWindowHandles(); }
    @Override public String getWindowHandle() { return driver.getWindowHandle(); }
}
