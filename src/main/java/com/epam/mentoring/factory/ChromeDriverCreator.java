package com.epam.mentoring.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;

public class ChromeDriverCreator extends WebDriverCreator {

    @Override
    public WebDriver FactoryMethod() {
        System.setProperty("webdriver.chrome.driver", "d:\\CDP_Autotests\\HomeWorks\\Lesson8\\mentoring_module_9_web_driver\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
}
