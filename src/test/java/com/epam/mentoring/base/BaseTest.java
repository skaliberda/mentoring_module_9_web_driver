package com.epam.mentoring.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.epam.mentoring.core.Utils;

public class BaseTest {

	protected static WebDriver driver;
	
	protected static WebDriver getDriver() {
       	  
		String browser = java.lang.System.getProperties().getProperty("webbrowser");
		
		if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//src//test/resources//chromedriver.exe");
			driver = new ChromeDriver();  
		} else  {
			System.out.println("WebDriver " + browser + " is not defined");
		}
		
       	driver.manage().timeouts().implicitlyWait(Integer.parseInt(Utils.getProperty("timeout")), TimeUnit.SECONDS);//timeout
       	driver.manage().window().maximize();
       	return driver;             
    }
	
	@BeforeSuite
	public void setUp() throws IOException{
        if (driver == null) {
        	driver = getDriver();
        }
	}
	
	@AfterSuite
	public void tearDown() throws IOException{
		takeScreenshot();
		driver.quit();
	}
	

	public void takeScreenshot() throws IOException{
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(".//target//screen.jpg"));
	}
}
