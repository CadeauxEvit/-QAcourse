package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutPage extends BasePage {
    By firstNameField = By.cssSelector("#firstname");
    By firstNameError = By.cssSelector("#firstname-error");
    By lastNameField = By.cssSelector("#lastname");
    By lastNameError = By.cssSelector("#lastname-error");
    By emailField = By.cssSelector("#email");
    By emailError = By.cssSelector("#email-error");
    By choosePicture = By.cssSelector("#wizard-picture");
    By nextButton = By.cssSelector("#next");

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    //Methods
    public void fillForm(String firstname, String lastname, String email){
        fillFirstName(firstname);
        fillLastName(lastname);
        fillEmail(email);
        clickNext();
    }

    public void clickNext() {
        driver.findElement(nextButton).click();
    }

    public void fillFirstName(String text){
        fillText(driver.findElement(firstNameField), text);
    }
    public String getFirstNameError(){
        return getElementText(driver.findElement(firstNameError));
    }
    public void fillLastName(String text){
        fillText(driver.findElement(lastNameField), text);
    }
    public String getLastNameError(){
        return getElementText(driver.findElement(lastNameError));
    }
    public void fillEmail(String text){
        fillText(driver.findElement(emailField), text);
    }
    public String getEmailError(){
        return getElementText(driver.findElement(emailError));
    }

}
