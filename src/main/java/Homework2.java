import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Homework2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://devexpress.github.io/testcafe/example/");
        Thread.sleep(5000);

        String name = "Alex";
        driver.findElement((By.xpath("//input [@id='developer-name']"))).sendKeys(name);

        List<WebElement> checkBoxes = driver.findElements((By.xpath("//input [@type='checkbox']")));
        for (WebElement result : checkBoxes) {
            result.click();
        }
        driver.findElement((By.xpath("//input[@id='macos']"))).click();
        driver.findElement((By.xpath("//*[@id=\"preferred-interface\"]"))).click();
        driver.findElement((By.xpath("//option[3]"))).click();

        driver.findElement((By.xpath("//div[@id='slider']"))).click();
        driver.findElement((By.xpath("//textarea[@id='comments']"))).sendKeys("Comment 123@#$\nGood comment");
        Thread.sleep(5000);
        driver.findElement((By.xpath("//button[@id='submit-button']"))).submit();
        Thread.sleep(5000);

        String thankYou =  driver.findElement((By.xpath("//h1[@id='article-header']"))).getText();
        if (thankYou.equals("Thank you, " +name + '!'))
            System.out.println("Name is correct, test passed.");
        else System.out.println("Error. Wrong name!");

        driver.quit();


    }
}

