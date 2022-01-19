import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Homework1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");

        // find the Search field
        WebElement searchField = driver.findElement((By.xpath("//*[@id=\"twotabsearchtextbox\"]")));
        searchField.sendKeys("tent");
        Thread.sleep(2000);
        searchField.submit();
        Thread.sleep(5000);

        // Search results as a list
        for (int i = 1; i < 11; i++) {
            List<WebElement> listOfTents = driver.findElements(By.xpath("//span[@class = 'a-size-medium a-color-base a-text-normal']"));
            for (WebElement result : listOfTents) {

                System.out.println(result.getText());
            }
            WebElement nextButton = driver.findElement((By.xpath("//li[@class ='a-last']")));
            nextButton.click();
            Thread.sleep(5000);
            System.out.println("\n\n\n=========== Page " + i + " ===========\n\n\n");
        }

       driver.quit();

    }
}
