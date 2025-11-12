package org.driver;

import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class WebElementDecorator implements WebElement {

    private final WebElement element;
    private static final Logger log = LoggerFactory.getLogger(WebElementDecorator.class);

    public WebElementDecorator(WebElement element) {
        this.element = element;
    }

    @Override
    public void click() {
        log.info("Clicking on element: {}", element);
        element.click();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        log.info("Typing into element: {} | Text: {}", element, String.join("", keysToSend));
        element.sendKeys(keysToSend);
    }

    @Override
    public String getText() {
        String text = element.getText();
        log.info("Getting text from element: {} | Text: {}", element, text);
        return text;
    }

    @Override
    public List<WebElement> findElements(By by) {
        log.info("Finding many elements by {}", by);
        return element.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        log.info("Finding element by {}", by);
        return element.findElement(by);
    }

    // Other unused methods TODO
    @Override public boolean isDisplayed() { return element.isDisplayed(); }
    @Override
    public Point getLocation() {
        return element.getLocation();
    }
    @Override
    public Dimension getSize() {
        return element.getSize();
    }
    @Override
    public Rectangle getRect() {
        return element.getRect();
    }
    @Override
    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }
    @Override public boolean isEnabled() { return element.isEnabled(); }
    @Override public boolean isSelected() { return element.isSelected(); }
    @Override public void clear() { element.clear(); }
    @Override public String getTagName() { return element.getTagName(); }
    @Override public String getAttribute(String name) { return element.getAttribute(name); }
    @Override public void submit() { element.submit(); }
    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
