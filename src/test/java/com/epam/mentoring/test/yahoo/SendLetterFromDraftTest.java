package com.epam.mentoring.test.yahoo;

import org.testng.annotations.Test;

import com.epam.mentoring.base.BaseTest;
import com.epam.mentoring.pages.yahoo.HomePage;
import com.epam.mentoring.pages.yahoo.MailTextEditor;

public class SendLetterFromDraftTest extends BaseTest {

	@Test
	public void testSendLetterFromDraft() {
		HomePage homePage = new HomePage(driver);
		homePage.openDrafts();
		MailTextEditor textEditor = homePage.openPreparedDraft();
		textEditor.verifyLetterAttributes("a.n.lyvin@gmail.com", "Test letter", "Hi, here is text of message");
		homePage = textEditor.sendDraft();
		homePage.verifyDraftAbsent();
		homePage.viewSentLetters();
	}
}
