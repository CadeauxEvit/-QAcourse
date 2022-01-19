import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;

public class LocatorsTraining {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.automation.co.il/tutorials/selenium/demo1/indexID.html");

        driver.findElement(By.id("firstname")).sendKeys("Alex");
        Thread.sleep(2000);
        driver.findElement(By.id("next")).click();

        String emailError = driver.findElement(By.id("email-error")).getText();
//        System.out.println("emailError = " + emailError);
        if (emailError.equalsIgnoreCase("This field is required."))
            System.out.println("Error message is correct");
        else System.out.println("Error message is wrong");

        String firstNameError = driver.findElement(By.id("firstname-error")).getText();
//        System.out.println("emailError = " + emailError);
        if (firstNameError.equalsIgnoreCase("This field is required."))
            System.out.println("Error message is correct");
        else System.out.println("Error message is wrong");

        driver.quit();
    }
}
