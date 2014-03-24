package com.epam.mentoring.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InternetExplorerDriverCreator extends WebDriverCreator {

    @Override
    public WebDriver FactoryMethod() {
        System.setProperty("webdriver.ie.driver",
                "src\\test\\resources\\iedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        driver = new InternetExplorerDriver(capabilities);
        return driver;
    }
}
