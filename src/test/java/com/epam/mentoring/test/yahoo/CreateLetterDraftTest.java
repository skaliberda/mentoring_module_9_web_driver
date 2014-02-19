package com.epam.mentoring.test.yahoo;

import org.testng.annotations.Test;

import com.epam.mentoring.base.BaseTest;
import com.epam.mentoring.core.TestData;
import com.epam.mentoring.core.TestDataBuilder;
import com.epam.mentoring.pages.yahoo.HomePage;
import com.epam.mentoring.pages.yahoo.MailTextEditor;

public class CreateLetterDraftTest extends BaseTest {

	TestDataBuilder testDataBuild = new TestDataBuilder();
	TestData testData = testDataBuild.setAddresse("a.n.lyvin@gmail.com").setSubject("Test letter").setBody("Letter body from Builder constructor").build();
		
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
