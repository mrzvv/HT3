package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepositorySettingsPage extends AbstractPage {
    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//button[contains(text(),'Delete this repository')]")
    private WebElement buttonDeleteRepository;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div[1]/div/div[2]/div/div[10]/ul/li[4]/div/div/div/div/div[2]/form/p/input")
    private WebElement form;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div[1]/div/div[2]/div/div[10]/ul/li[4]/div/div/div/div/div[2]/form/button")
    private WebElement deleteRepoButton;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div[1]/div/div[2]/div/div[10]/ul/li[4]/div/div/div/div/div[2]/p[1]/strong[2]")
    private WebElement projectName;

    @FindBy(id = "rename_field")
    private WebElement repoName;

    public RepositorySettingsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getRepoName() {
        System.out.println(projectName.getText());
        return projectName.getText();
    }

    public void clickDeleteRepo() {
        buttonDeleteRepository.click();
    }

    public void submitDeletion(String repoName) {
        form.clear();
        form.sendKeys(repoName);
        deleteRepoButton.click();
        logger.info("Clicked on button for deletion repo");
    }

    @Override
    public void openPage(){

    }
}
