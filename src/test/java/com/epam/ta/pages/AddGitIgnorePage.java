package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddGitIgnorePage extends AbstractPage {

    @FindBy(xpath = "//button/i[contains(text(),'Choose .gitignore:')]")
    private WebElement buttonChooseTemplate;

    @FindBy(id = "context-ignore-filter-field")
    private WebElement inputTemplate;

    @FindBy(xpath = "//div[contains(text(), 'Java')]")
    private WebElement java;

    @FindBy(id = "commit-summary-input")
    private WebElement inputCommitMessage;

    @FindBy (id = "submit-file")
    private WebElement submit;

    public AddGitIgnorePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickChooseTemplateButton() {
        buttonChooseTemplate.click();
    }

    public void searchJavaTemplate() {
        inputTemplate.sendKeys("java");
    }

    public void selectJavaTemplate() {
        java.click();
    }

    public void writeCommitMessage() {
        inputCommitMessage.sendKeys("first .gitignore commit");
    }

    public void submitAddingGitIgnore() {
        submit.click();
    }

    @Override
    public void openPage() {

    }
}
