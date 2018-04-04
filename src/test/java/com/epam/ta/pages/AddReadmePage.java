package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddReadmePage extends AbstractPage {
    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "submit-file")
    private WebElement buttonSubmitReadme;

    @FindBy(className = "CodeMirror")
    private WebElement codeMirror;

    public AddReadmePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void writeInReadme(String message) {
        codeMirror.click();
        (new Actions(driver)).sendKeys(" " + message).build().perform();
        logger.info("Wrote message in readme.md");
    }

    public void submitAddingReadme() {
        buttonSubmitReadme.click();
        logger.info("");
    }

    @Override
    public void openPage() {

    }
}
