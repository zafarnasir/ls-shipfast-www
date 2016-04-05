package com.shipfast.test.acceptance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
    private final WebDriver driver;

    @FindBy(css = "input[name=q]")
    WebElement query;

    @FindBy(css = "input[value=\"Google Search\"]")
    WebElement searchButton;

    @FindBy(css = "input[value=\"I'm Feeling Lucky\"]")
    WebElement luckyButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 1), this);
    }

    public static HomePage loadUsing(WebDriver driver) {
        driver.get("http://www.google.com/");
        return new HomePage(driver);
    }

    public HomePage setQuery(String term) {
        query.clear();
        query.sendKeys(term);
        return this;
    }

    public HomePage pressEnterInQuery() {
        query.sendKeys("\n");
        return new HomePage(driver);
    }

    public HomePage clickSearchButton() {
        searchButton.click();
        return new HomePage(driver);
    }

    public HomePage clickLuckyButton() {
        luckyButton.click();
        return new HomePage(driver);
    }
}
