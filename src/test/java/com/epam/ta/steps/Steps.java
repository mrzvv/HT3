package com.epam.ta.steps;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Steps {
    private final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;

    public void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeDriver() {
        DriverSingleton.closeDriver();
    }

    public void loginGithub(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }

    public boolean isLoggedIn(String username) {
        LoginPage loginPage = new LoginPage(driver);
        String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
        logger.info("Actual username: " + actualUsername);
        return actualUsername.equals(username);
    }

    public boolean createNewRepository(String repositoryName, String repositoryDescription) {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnCreateNewRepositoryButton();
        CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
        String expectedRepoName = createNewRepositoryPage.createNewRepository(repositoryName, repositoryDescription);
        return expectedRepoName.equals(createNewRepositoryPage.getCurrentRepositoryName());
    }

    public boolean currentRepositoryIsEmpty() {
        CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
        return createNewRepositoryPage.isCurrentRepositoryEmpty();
    }

    public boolean deleteCreatedRepository() {
        RepositoryPage repositoryPage = new RepositoryPage(driver);
        repositoryPage.goToSettings();
        RepositorySettingsPage repositorySettingsPage = new RepositorySettingsPage(driver);
        repositorySettingsPage.clickDeleteRepo();
        repositorySettingsPage.submitDeletion(repositorySettingsPage.getRepoName());
        MainPage mainPage = new MainPage(driver);
        return mainPage.successfulDeletion();
    }

    public boolean addReadme(String message) {
        RepositoryPage repositoryPage = new RepositoryPage(driver);
        repositoryPage.clickAddAReadme();
        AddReadmePage addReadmePage = new AddReadmePage(driver);
        addReadmePage.writeInReadme(message);
        addReadmePage.submitAddingReadme();
        return repositoryPage.confirmAddingReadme();
    }

    public boolean addGitIgnore() {
        RepositoryPage repositoryPage = new RepositoryPage(driver);
        repositoryPage.clickAddGitIgnore();
        AddGitIgnorePage addGitIgnorePage = new AddGitIgnorePage(driver);
        addGitIgnorePage.clickChooseTemplateButton();
        addGitIgnorePage.searchJavaTemplate();
        addGitIgnorePage.selectJavaTemplate();
        addGitIgnorePage.writeCommitMessage();
        addGitIgnorePage.submitAddingGitIgnore();
        return repositoryPage.confirmAddingGitIgnore();
    }
}
