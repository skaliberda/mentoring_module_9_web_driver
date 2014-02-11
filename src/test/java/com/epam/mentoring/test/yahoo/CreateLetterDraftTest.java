package com.epam.mentoring.test.yahoo;

import org.testng.annotations.Test;

import com.epam.mentoring.base.BaseTest;
import com.epam.mentoring.pages.yahoo.HomePage;
import com.epam.mentoring.pages.yahoo.MailTextEditor;

public class CreateLetterDraftTest extends BaseTest {

	@Test 
	public void testCreateLetterDraft() {
		HomePage homePage = new HomePage(driver);
		MailTextEditor textEditor = homePage.createNewLetter();
		textEditor.fillAddressee(testData.getAddressee());
		textEditor.fillTopic(testData.getSubject());
		textEditor.fillLetterBody(testData.getBody());
		textEditor.verifyDraftAutosaved();
	}
}
