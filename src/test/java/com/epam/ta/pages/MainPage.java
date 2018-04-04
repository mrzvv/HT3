package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
    private final String BASE_URL = "https://github.com/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@id=\"your_repos\"]/div/div[1]/a")
    private WebElement linkNewRepository;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnCreateNewRepositoryButton() {
        linkNewRepository.click();
    }

    public boolean successfulDeletion() {
        String code = driver.getPageSource();
        return code.contains("was successfully deleted");
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
