import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ByTypeTraining {
    public static void main(String[] args) throws InterruptedException {

        //Headless Mode
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless", "--window-size=1920,1200");
//        WebDriver driver = new ChromeDriver(options);


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automation.co.il/tutorials/selenium/demo1/indexID.html");
        Thread.sleep(3000);


        //Elements
        //First page
        By nextButton = By.cssSelector("#next");
        By firstNameField = By.cssSelector("#firstname");
        By lastNameField = By.cssSelector("#lastname");
        By emailField = By.cssSelector("#email");
        By choosePicture = By.cssSelector("#wizard-picture");
        // Second page
        By beginnerLevel = By.cssSelector("#Beginner");
        By intermediateLevel = By.cssSelector("#Intermediate");
        By advancedLevel = By.cssSelector("#Advanced");
        By previousButton = By.xpath("//input[@name='previous']");
        // Third page
        By streetNameField = By.cssSelector("#streetname");
        By streetNumberField = By.cssSelector("#streetnumber");
        By cityField = By.cssSelector("#city");
        By countryField = By.cssSelector("#country");
        By finishButton = By.cssSelector("#finish");
        // Finish
        By startAgainButton = By.cssSelector("#startAgain");





        //Click on Next button
        driver.findElement(nextButton).click();

        //Check error message
        String firstNameError = driver.findElement(By.cssSelector("#firstname-error")).getText();
        if (firstNameError.equals("This field is required.")) {
            System.out.println("First name error message is correct");
        } else {
            System.out.println("First name error message is incorrect");
        }

        //Fill first name
        driver.findElement(firstNameField).sendKeys("Alex");
        //Click on Next button
        driver.findElement(nextButton).click();

        //Check last name error
        String lastNameError = driver.findElement(By.cssSelector("#lastname-error")).getText();
        if (lastNameError.equals("This field is required.")) {
            System.out.println("Last name error message is correct");
        } else {
            System.out.println("Last name error message is incorrect");
        }

        //Fill last name
        driver.findElement(lastNameField).sendKeys("Komanov");

        //Click on the next button
        driver.findElement(nextButton).click();

        String emailError = driver.findElement(By.cssSelector("#email-error")).getText();
        if (emailError.equals("This field is required.")) {
            System.out.println("Error message is correct");
        } else {
            System.out.println("Error message is incorrect");
        }

        //Fill email address
        driver.findElement(emailField).sendKeys("alex@gmail.com");
        //Click on the next button
        driver.findElement(nextButton).click();

        Thread.sleep(1000);
        boolean isDisplayed = driver.findElement(beginnerLevel).isDisplayed();
        if(isDisplayed) {
            System.out.println("We were redirected");
        }
        else {
            System.out.println("We were not redirected");
        }

        //Clicking three icons
        driver.findElement(beginnerLevel).click();
        driver.findElement(intermediateLevel).click();
        driver.findElement(advancedLevel).click();

        //Clicking Next button
        driver.findElement(nextButton).click();

        Thread.sleep(3000);

        //Store the element as WebElement variable
        WebElement element = driver.findElement(streetNameField);
        String id = element.getAttribute("id");
        String value = element.getAttribute("value");
        System.out.println("id = " + id);
        System.out.println("value = " + value);
        element.clear();
        element.sendKeys("Nahal Dan");

        //Fill form in this page
        driver.findElement(streetNumberField).sendKeys("68");
        driver.findElement(cityField).sendKeys("Karmiel");

        //Find select element by id
        WebElement selectElement = driver.findElement(countryField);
        //Creating new variable of Select type
        Select select = new Select(selectElement);
        //Select by Visible Text
        select.selectByVisibleText("Israel");
        //Select by Index
        select.selectByIndex(0);
        //Select by Value
        select.selectByValue("Argentina");
        //Click on the Finish button
        driver.findElement(finishButton).click();


        // Find element with elements combination
       // WebElement buttonElement = driver.findElement(By.cssSelector("[class='loginFrame'] [type='button']"));



        Thread.sleep(2000);
        driver.quit();
    }
}

