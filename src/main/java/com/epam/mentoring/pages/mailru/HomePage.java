package com.epam.mentoring.pages.mailru;

import com.epam.mentoring.core.Utils;
import com.epam.mentoring.pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//i[@class='x-ph__menu__button__text x-ph__menu__button__text_auth']")
    private WebElement verNameLabel;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyLoggedUserName(String verName) {
        Assert.assertEquals("User name is not equal or is not find. Maybe, user was not logged propertly", verName, verNameLabel.getText());
    }
}
