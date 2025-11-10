package org.pages;

import org.base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By dashboardTitle = By.xpath("//div[@class='app_logo']");

    public String getDashboardTitle() {
        return find(dashboardTitle).getText();
    }
}
