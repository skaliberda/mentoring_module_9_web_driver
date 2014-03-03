package com.epam.mentoring.factory;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverCreator {
    protected WebDriver driver;

    public abstract WebDriver FactoryMethod();
}
