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
		textEditor.fillAddressee("a.n.lyvin@gmail.com");
		textEditor.fillTopic("Test letter");
		textEditor.fillLetterBody("Hi, here is text of message");
		textEditor.verifyDraftAutosaved();
	}
}
