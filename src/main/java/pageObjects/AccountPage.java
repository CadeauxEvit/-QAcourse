package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{

    //Elements
    By beginnerLevel = By.cssSelector("#Beginner");
    By intermediateLevel = By.cssSelector("#Intermediate");
    By advancedLevel = By.cssSelector("#Advanced");
    By previousButton = By.xpath("//input[@name='previous']");
    By nextButton = By.cssSelector("#next");


    // Constructor
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    //Methods
    public void clickIcons(){
        clickElement(driver.findElement(beginnerLevel));
        clickElement(driver.findElement(intermediateLevel));
        clickElement(driver.findElement(advancedLevel));
    }

    public void clickNext() {
        driver.findElement(nextButton).click();
    }
    public boolean accountPageIsDisplayed(){
        return elementIsDisplayed(driver.findElement(beginnerLevel));
    }
}
