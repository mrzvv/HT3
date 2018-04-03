package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepositoryPage extends AbstractPage {
    private final String USERNAME = "testautomationuser";
    private String BASE_URL;

    @FindBy(linkText = "Settings")
    private WebElement linkSettings;

    @FindBy(linkText = "README")
    private WebElement linkAddReadme;

    @FindBy(linkText = "README.md")
    private WebElement linkReadme;

    @FindBy(linkText = ".gitignore")
    private WebElement linkAddGitIgnore;

    @FindBy(linkText = "first .gitignore commit")
    private WebElement commitMessage;

    public RepositoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        this.BASE_URL = "http://www.github.com/" + USERNAME + "/";
    }

    public void goToSettings() {
        linkSettings.click();
    }

    public void clickAddAReadme() {
        linkAddReadme.click();
    }

    public void clickAddGitIgnore() {
        linkAddGitIgnore.click();
    }

    public boolean confirmAddingReadme() {
        return linkReadme.isDisplayed();
    }

    public boolean confirmAddingGitIgnore() {
        return commitMessage.isDisplayed();
    }

    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
