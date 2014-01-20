package com.epam.mentoring.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.epam.mentoring.core.Utils;


public class BaseTest {

	protected WebDriver driver;
	
	@BeforeClass
	public void setUp() throws IOException{
        System.setProperty("webdriver.chrome.driver", ".//src//test/resources//chromedriver.exe");
        driver = new ChromeDriver();      
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Utils.getProperty("timeout")), TimeUnit.SECONDS);//timeout
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() throws IOException{
		takeScreenshot();
		driver.quit();
	}
	

	public void takeScreenshot() throws IOException{
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(".//target//screen.jpg"));
	}
}
