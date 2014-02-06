package com.epam.mentoring.test.yahoo;

import org.testng.annotations.Test;

import com.epam.mentoring.base.BaseTest;
import com.epam.mentoring.core.Utils;
import com.epam.mentoring.pages.yahoo.HomePage;
import com.epam.mentoring.pages.yahoo.LoginPage;


public class LoginTest extends BaseTest {
	
	@Test 
	public void testLogin() throws Exception{		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openUrl(Utils.getProperty("yahoo.url"));
		HomePage homePage = loginPage.login(Utils.getProperty("yahoo.username"), Utils.getProperty("yahoo.password"));
		homePage.verifyUserName(Utils.getProperty("yahoo.verName"));
	}
}