package com.epam.mentoring.pages.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.epam.mentoring.pages.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(xpath="//a[@class='gb_f gb_j']")
	private WebElement verNameLabel;
	
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void verifyUserName(String verName) {
		System.out.println(verNameLabel.getText());
		Assert.assertEquals(verNameLabel.getText(), verName, "Name for logged in user is not found. Probably user is not logged in propertly");
	}

}
