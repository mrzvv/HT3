package com.epam.ta.pages;

import com.epam.ta.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewRepositoryPage extends com.epam.ta.pages.AbstractPage {
    private final String BASE_URL = "http://www.github.com/new";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "repository_name")
    private WebElement inputRepositoryName;

    @FindBy(id = "repository_description")
    private WebElement inputRepositoryDescription;

    @FindBy(xpath = "//form[@id='new_repository']//button[@type='submit']")
    private WebElement butttonCreate;

    @FindBy(id = "empty-setup-clone-url")
    private WebElement elementWithIdEmptyProject;

    @FindBy(className = "empty-repo-setup-option")
    private WebElement labelEmptyRepoSetupOption;

    @FindBy(xpath = "//a[@data-pjax='#js-repo-pjax-container']")
    private WebElement linkCurrentRepository;

    public CreateNewRepositoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean isCurrentRepositoryEmpty() {
        return elementWithIdEmptyProject.isDisplayed();
    }

    public String createNewRepository(String repositoryName, String repositoryDescription) {
        String repositoryFullName = repositoryName + Utils.getRandomString(6);
        inputRepositoryName.sendKeys(repositoryFullName);
        inputRepositoryDescription.sendKeys(repositoryDescription);
        butttonCreate.click();
        logger.info("Clicked on button for creating new repo");
        return repositoryFullName;
    }

    public String getCurrentRepositoryName() {
        return linkCurrentRepository.getText();
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
