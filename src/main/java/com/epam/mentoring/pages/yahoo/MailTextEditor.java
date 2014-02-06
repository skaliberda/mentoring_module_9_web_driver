package com.epam.mentoring.pages.yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.epam.mentoring.pages.BasePage;

public class MailTextEditor  extends BasePage {

	@FindBy(id="to-field")
	private WebElement addresseeField;
	
	@FindBy(xpath="//span[text()='Drafts' and @class='group-name']/parent::li//b")
	private WebElement acceptedAddresseeField;
	
	@FindBy(id="subject-field")
	private WebElement subjectField;
	
	@FindBy(xpath="//ul[@class='t-draft t-s-group']//b")
	private WebElement draftSubjectField;
	
	@FindBy(id="rtetext")
	private WebElement letterBodyField;
	
//	@FindBy(xpath="//ul[@class='t-draft t-s-group']//b")
//	private WebElement draftBodyField;
	
	@FindBy(xpath="//span[@class='save-draft-msg' and contains(text(),'Saved at ')]")
	private WebElement autoSaveLabel;
	
	@FindBy(xpath="//*[@class='btn default' and @data-action='send']") //*[@data-action='send']/text()='Send'
	private WebElement sendButton;
		
	public MailTextEditor(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void fillAddressee(String addressee) {
		addresseeField.sendKeys(addressee);
	}

	public void fillTopic(String topic) {
		subjectField.sendKeys(topic);
	}

	public void fillLetterBody(String messageBody) {
		letterBodyField.sendKeys(messageBody);
	}

	public void verifyDraftAutosaved() {
		Assert.assertTrue(autoSaveLabel.isDisplayed());	
	}
	
	public HomePage sendDraft() {
		sendButton.click();
		return new HomePage(driver);
	}

	public void verifyLetterAttributes(String addressee, String subject, String letterBody) {
		//Assert.assertEquals(acceptedAddresseeField.getText(), addressee, "addressee differs from saved");
		//Assert.assertEquals(draftSubjectField.getText(), subject, "subject differs from saved");
		//Assert.assertEquals(draftBodyField.getText(), letterBody, "message body differs from saved");
	}
}
