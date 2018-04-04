package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddGitIgnorePage extends AbstractPage {
    private static final Logger logger = LogManager.getRootLogger();

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
        logger.info("Clicked on button 'Choose template'");
    }

    public void searchJavaTemplate() {
        inputTemplate.sendKeys("java");
        logger.info("Searching for java template...");
    }

    public void selectJavaTemplate() {
        java.click();
        logger.info("Java template is selected");
    }

    public void writeCommitMessage() {
        inputCommitMessage.sendKeys("first .gitignore commit");
        logger.info("Writing commit message...");
    }

    public void submitAddingGitIgnore() {
        submit.click();
        logger.info("Committed first .gitignore");
    }

    @Override
    public void openPage() {

    }
}
