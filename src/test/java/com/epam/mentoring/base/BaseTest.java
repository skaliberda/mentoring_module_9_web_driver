package com.epam.mentoring.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.epam.mentoring.decorator.DriverDecorator;
import com.epam.mentoring.factory.ChromeDriverCreator;
import com.epam.mentoring.factory.FirefoxDriverCreator;
import com.epam.mentoring.factory.InternetExplorerDriverCreator;
import com.epam.mentoring.factory.WebDriverCreator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.epam.mentoring.core.Utils;

public class BaseTest {

    protected static WebDriver driver;

    protected static WebDriver getDriver() {

        String browser = java.lang.System.getProperties().getProperty("webbrowser");

        if (browser == null) {
            browser = "firefox";
        }
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverCreator creator = new FirefoxDriverCreator();
            driver = creator.FactoryMethod();
            driver = new DriverDecorator(driver);
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverCreator creator = new ChromeDriverCreator();
            driver = creator.FactoryMethod();
            driver = new DriverDecorator(driver);
        } else if (browser.equalsIgnoreCase("iexplorer")) {
            WebDriverCreator creator = new InternetExplorerDriverCreator();
            driver = creator.FactoryMethod();
            driver = new DriverDecorator(driver);
        } else {
            System.out.println("WebDriver " + browser + " is not defined");
        }
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(Utils.getProperty("timeout")), TimeUnit.SECONDS);// timeout
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeSuite
    public void setUp() throws IOException {
        if (driver == null) {
            driver = getDriver();
        }
    }

    @AfterSuite
    public void tearDown() throws IOException {
        takeScreenshot();
        driver.quit();
    }

    public void takeScreenshot() throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(".//target//screen.jpg"));
    }
}
