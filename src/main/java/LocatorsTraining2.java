import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatorsTraining2 {
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

        //Click on Next button
        driver.findElement(By.cssSelector("#next")).click();

        //Check error message
        String firstNameError = driver.findElement(By.cssSelector("[id='firstname-error']")).getText();
        if (firstNameError.equals("This field is required.")) {
            System.out.println("First name error message is correct");
        } else {
            System.out.println("First name error message is incorrect");
        }

        //Fill first name
        driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("Alex");
        //Click on Next button
        driver.findElement(By.cssSelector("#next")).click();

        //Check last name error
        String lastNameError = driver.findElement(By.xpath("//*[@id='lastname-error']")).getText();
        if (lastNameError.equals("This field is required.")) {
            System.out.println("Last name error message is correct");
        } else {
            System.out.println("Last name error message is incorrect");
        }

        //Fill last name
        driver.findElement(By.id("lastname")).sendKeys("Komanov");

        //Click on the next button
        driver.findElement(By.id("next")).click();

        String emailError = driver.findElement(By.id("email-error")).getText();
        if (emailError.equals("This field is required.")) {
            System.out.println("Error message is correct");
        } else {
            System.out.println("Error message is incorrect");
        }

        //Fill email address
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("alex@gmail.com");
        //Click on the next button
        driver.findElement(By.cssSelector("[id='next']")).click();

        Thread.sleep(1000);
        boolean isDisplayed = driver.findElement(By.id("Beginner")).isDisplayed();
        if(isDisplayed) {
            System.out.println("We were redirected");
        }
        else {
            System.out.println("We were not redirected");
        }

        //Clicking three icons
        driver.findElement(By.cssSelector("[id='Beginner']")).click();
        driver.findElement(By.cssSelector("[id='Intermediate']")).click();
        driver.findElement(By.cssSelector("[id='Advanced']")).click();

        //Clicking Next button
        driver.findElement(By.cssSelector("[id='next']")).click();

        Thread.sleep(3000);

        //Store the element as WebElement variable
        WebElement element = driver.findElement(By.cssSelector("[id='streetname']"));
        String id = element.getAttribute("id");
        String value = element.getAttribute("value");
        System.out.println("id = " + id);
        System.out.println("value = " + value);
        element.clear();
        element.sendKeys("Nahal Dan");

        //Fill form in this page
        driver.findElement(By.cssSelector("[id='streetnumber']")).sendKeys("68");
        driver.findElement(By.cssSelector("[id='city']")).sendKeys("Karmiel");

        //Find select element by id
        WebElement selectElement = driver.findElement(By.cssSelector("[name='country']"));
        //Creating new variable of Select type
        Select select = new Select(selectElement);
        //Select by Visible Text
        select.selectByVisibleText("Israel");
        //Select by Index
        select.selectByIndex(0);
        //Select by Value
        select.selectByValue("Argentina");
        //Click on the Finish button
        driver.findElement(By.cssSelector("[id='finish']")).click();


        // Find element with elements combination
        WebElement buttonElement = driver.findElement(By.cssSelector("[class='loginFrame'] [type='button']"));



        Thread.sleep(2000);
        driver.quit();
    }
}

