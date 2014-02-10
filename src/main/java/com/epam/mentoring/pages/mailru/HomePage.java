package com.epam.mentoring.pages.mailru;

import com.epam.mentoring.configuration.Configuration;
import com.epam.mentoring.pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//i[@class='x-ph__menu__button__text x-ph__menu__button__text_auth']")
    private WebElement verNameLabel;

    @FindBy(xpath = "//a[contains(@title,'Написать письмо')]")
    private WebElement sendNewEMail;

    @FindBy(xpath = "//input[contains(@data-original-name, 'To')]")
    private WebElement letterAddress;

    @FindBy(xpath = ".//input[contains(@name,'Subject')]")
    private WebElement letterTheme;

    @FindBy(xpath = "//span[text() = 'Отправить']")
    private WebElement sendLetter;

    @FindBy(xpath = "//span[text() = 'Сохранить']")
    private WebElement saveLetter;

    @FindBy(xpath = "//span[text() = 'Черновики']")
    private WebElement draftLink;

    @FindBy(xpath = "//div[contains(@data-name, 'saveStatus')]")
    private WebElement saveStatusMessage;

    private final String draftRow = "//a[contains(@title,'%s')]";

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyLoggedUserName(String verName) {
        Assert.assertEquals("User name is not equal or is not find. Maybe, user was not logged propertly", verName,
                verNameLabel.getText());
    }

    public void writeNewEMail() {
        sendNewEMail.click();
    }

    public void addAddress(String address) {
        letterAddress.sendKeys(address);
    }

    public void addTheme(String theme) {
        letterTheme.sendKeys(theme);
    }

    public void addLetterText(String letterText) {
        driver.switchTo().frame(
                driver.findElement(By.xpath("//div[contains(@class,'b-compose__editor__frame')]//iframe")));
        WebElement editable = driver.switchTo().activeElement();
        editable.sendKeys(letterText);
        driver.switchTo().defaultContent();
    }

    public void clickSaveButton() {
        saveLetter.click();
    }

    private boolean isAlertPresent() {
        try{
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public void clickDraftLink() {
        draftLink.click();
    }

    public void checkSavedDrafts(String addressPath) {
        if (isAlertPresent()) {
            driver.switchTo().alert().accept();
        }
        Assert.assertTrue("Letter was not saved into draft.", driver.findElement(By.xpath(getDraftRow(addressPath)))
                .isDisplayed());
    }

    public void openDraftLetter(String addressPath) {
        driver.findElement(By.xpath(getDraftRow(addressPath))).click();
    }

    private String getDraftRow(String addressPath) {
        return String.format(draftRow, addressPath);
    }

}
