package com.epam.mentoring.test.mailru;

import com.epam.mentoring.base.BaseTest;
import com.epam.mentoring.core.Utils;
import com.epam.mentoring.pages.mailru.HomePage;
import com.epam.mentoring.pages.mailru.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void sendMail() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.openUrl(Utils.getProperty("mailru.url"));
        loginPage.loginToMailBox(Utils.getProperty("mailru.username"), Utils.getProperty("mailru.domain"),
                Utils.getProperty("mailru.password"));
        homePage.verifyLoggedUserName(Utils.getProperty("mailru.verName"));
        homePage.writeNewEMail();

    }

}