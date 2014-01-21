package com.epam.mentoring.pages.mailru;

import com.epam.mentoring.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BasePage {

    @FindBy(id = "mailbox__login")
    private WebElement userLogin;

    @FindBy(id = "mailbox__password")
    private WebElement userPassword;

    @FindBy(id = "mailbox__login__domain")
    private WebElement userDomain;

    @FindBy(id = "mailbox__auth__button")
    private WebElement signIn;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void loginToMailBox(String login, String domain, String password) {
        userLogin.sendKeys(login);
        getDomainField().selectByVisibleText(domain);
        userPassword.sendKeys(password);
        signIn.click();
    }

    private Select getDomainField() {
        Select domain = new Select(userDomain);
        return domain;
    }
}
