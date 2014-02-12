package com.epam.mentoring.pages.mailru;

import com.epam.mentoring.configuration.Configuration;
import com.epam.mentoring.pages.BasePage;
import com.google.common.base.Stopwatch;
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

    @FindBy(xpath = "//span[text() = 'Отправленные']")
    private WebElement sendedLink;

    @FindBy(xpath = "//div[contains(@data-name, 'saveStatus')]")
    private WebElement saveStatusMessage;

    @FindBy(xpath = "//div[text() = 'У вас нет незавершенных писем']")
    private WebElement noDraftLetters;

    @FindBy(xpath = "//a[text() = 'выход']")
    private WebElement logOut;

    @FindBy(xpath = "//div[contains(@class, 'is-submit_empty_message_in')]//button[@class = 'btn btn_stylish btn_main confirm-ok']")
    private WebElement confirmationSend;

    private final String addressContainer = "//span[@class = 'js-compose-label compose__labels__label']//span[text() = '%s']";
    private final String draftRow = "//a[contains(@title,'%s')]";

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyLoggedUserName(String verName) {
        waitForPageReady();
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

    private String getLetterText() {
        driver.switchTo().frame(
                driver.findElement(By.xpath("//div[contains(@class,'b-compose__editor__frame')]//iframe")));
        WebElement editable = driver.switchTo().activeElement();
        String content = editable.getText();
        driver.switchTo().defaultContent();
        return content;
    }

    public void clickSaveButton() {
        saveLetter.click();
    }

    private boolean isAlertPresent() {
        try {
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
        waitForPageReady();
        Assert.assertTrue("Letter was not saved into draft.", driver.findElement(By.xpath(getDraftRow(addressPath))).isEnabled());
    }

    public void openDraftLetter(String addressPath) {
        driver.findElement(By.xpath(getDraftRow(addressPath))).click();
    }

    private String getDraftRow(String addressPath) {
        return String.format(draftRow, addressPath);
    }

    private String getLetterDataLocator(String tempalteLocator, String locatorPath) {
        return String.format(tempalteLocator, locatorPath);
    }

    public void savedLetter(String address, String theme, String content) {
        Assert.assertTrue("Address is wrong.",
                address.equals(driver.findElement(By.xpath(getLetterDataLocator(addressContainer, address))).getText()));
        Assert.assertTrue("Content is wrong.", getLetterText().contains(content));
    }

    public void sendLetter() {
        sendLetter.click();
    }

    public void clickOnSendedLink() {
        sendedLink.click();
    }

    public void checkSendedLetter(String addressPath) {
        waitForPageReady();
        Assert.assertTrue("Letter was not present in Outbox", driver.findElement(By.xpath(getDraftRow(addressPath)))
                .isEnabled());
    }

    public void logOut() {
        logOut.click();
    }

    public void confirmationClick() {
        confirmationSend.click();
    }

    private void waitForPageReady() {
        Object status;
        do {
            status = ((JavascriptExecutor) driver).executeScript("return document.readyState");
        } while (!status.toString().equals("complete"));
    }
}
