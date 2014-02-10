package com.epam.mentoring.test.mailru;

import com.epam.mentoring.base.BaseTest;
import com.epam.mentoring.configuration.Configuration;
import com.epam.mentoring.dataprovider.CvsDataProvider;
import com.epam.mentoring.core.Utils;
import com.epam.mentoring.pages.mailru.HomePage;
import com.epam.mentoring.pages.mailru.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CvsDataProvider data = new CvsDataProvider();
        Configuration configuration = new Configuration(data.loadData());
        loginPage.openUrl(Utils.getProperty("mailru.url"));
        loginPage.loginToMailBox(Utils.getProperty("mailru.username"), Utils.getProperty("mailru.domain"),
                Utils.getProperty("mailru.password"));
        homePage.verifyLoggedUserName(Utils.getProperty("mailru.verName"));
        homePage.writeNewEMail();
        homePage.addAddress(configuration.getAddress());
        homePage.addTheme(configuration.getLetterTheme());
        homePage.addLetterText(configuration.getLetterContent());
        homePage.clickSaveButton();
        homePage.clickDraftLink();
        homePage.checkSavedDrafts(configuration.getAddress());
        homePage.openDraftLetter(configuration.getAddress());
        homePage.savedLetter(configuration.getAddress(), configuration.getLetterTheme(), configuration.getLetterContent());
        homePage.sendLetter();
        homePage.clickDraftLink();
        homePage.checkEmptyDraft();
        homePage.checkSendedLetter(configuration.getAddress());
        homePage.logOut();
    }
}