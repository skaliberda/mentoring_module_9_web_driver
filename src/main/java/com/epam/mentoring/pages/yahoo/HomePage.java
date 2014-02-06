package com.epam.mentoring.pages.yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.epam.mentoring.pages.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(xpath="//span[@class='yuhead-name yucs-fc']")
	private WebElement verNameLabel;
	
	@FindBy(xpath="//span[@class='icon-text' and text()='Compose']")
	private WebElement newLetterButton;
	
	@FindBy(xpath="//span[@class='icon-text' and text()='Drafts']")
	private WebElement draftsButton;
	
	@FindBy(xpath="//span[@class='icon-text' and text()='Sent']")
	private WebElement viewSentButton;
	
	@FindBy(xpath="//span[contains(text(),'Test letter')]")
	private WebElement letterWithKnownSubject;
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void verifyUserName(String verName) {
		System.out.println(verNameLabel.getText());
		Assert.assertEquals(verNameLabel.getText(), verName, "Name for logged in user is not found. Probably user is not logged in propertly");
	}
	
	public MailTextEditor createNewLetter() {
		newLetterButton.click();
		return new MailTextEditor(driver);
	}

	public MailTextEditor openPreparedDraft() {
		letterWithKnownSubject.click();
		return new MailTextEditor(driver);
	}

	public void verifyDraftAbsent() {
		Assert.assertFalse(letterWithKnownSubject.isDisplayed());	
	}

	public void viewSentLetters() {
		viewSentButton.click();
	}
	
	public void verifyDrfatWasSent() {
		Assert.assertTrue(letterWithKnownSubject.isDisplayed(), "There is no sent items with subject specified");
	}

	public void openDrafts() {
		draftsButton.click();
	}

}
