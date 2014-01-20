package com.epam.mentoring.test.gmail;

import org.testng.annotations.Test;

import com.epam.mentoring.base.BaseTest;
import com.epam.mentoring.core.Utils;
import com.epam.mentoring.pages.gmail.HomePage;
import com.epam.mentoring.pages.gmail.LoginPage;


public class LoginTest extends BaseTest {
	
	@Test/*(groups="smoke")*/
	public void testLogin() throws Exception{		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openUrl(Utils.getProperty("gmail.url"));
		HomePage homePage = loginPage.login(Utils.getProperty("gmail.username"), Utils.getProperty("gmail.password"));
		homePage.verifyUserName(Utils.getProperty("gmail.verName"));
	}
}