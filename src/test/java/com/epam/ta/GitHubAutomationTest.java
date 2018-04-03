package com.epam.ta;

import com.epam.ta.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GitHubAutomationTest {
    private final String USERNAME = "testautomationuser";
    private final String PASSWORD = "Time4Death!";
    private Steps steps;

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "Login to Github")
    public void oneCanLoginGithub() {
        steps.loginGithub(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }

    @Test(description = "Create new repo")
    public void oneCanCreateRepo() {
        steps.loginGithub(USERNAME, PASSWORD);
        Assert.assertTrue(steps.createNewRepository("testRepo", "auto-generated test repo"));
        Assert.assertTrue(steps.currentRepositoryIsEmpty());
    }

    @Test(description = "Add README")
    public void oneCanAddReadme() {
        steps.loginGithub(USERNAME, PASSWORD);
        steps.createNewRepository("testRepo", "auto-generated test repo");
        Assert.assertTrue(steps.addReadme("... with auto-generated README"));
    }

    @Test(description = "Add .gitignore with template for Java project")
    public void oneCanAddJavaTemplateGitIgnore() {
        steps.loginGithub(USERNAME, PASSWORD);
        steps.createNewRepository("testRepo", "auto-generated test repo");
        Assert.assertTrue(steps.addGitIgnore());
    }

    @Test(description = "Delete repo")
    public void oneCanDeleteRepo() {
        steps.loginGithub(USERNAME, PASSWORD);
        steps.createNewRepository("testRepo", "auto-generated test repo");
        Assert.assertTrue(steps.deleteCreatedRepository());
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}
