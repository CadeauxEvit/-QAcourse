import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebElementsTraining {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        //Store element as WebElement //
        WebElement inputElement = driver.findElement(By.xpath("//input[@id='_nkw']"));
        inputElement.clear();
        inputElement.sendKeys("mixer");
        inputElement.submit();
        Thread.sleep(5000);

//        WebElement upperSearchButton = driver.findElement(By.cssSelector("[class=\"adv-s mb space-top\"]>[type=\"submit\"]"));
//        upperSearchButton.click();
                //ctrl +alt+v
        List<WebElement> results = driver.findElements(By.xpath("//h3[@class='lvtitle']/a"));
        System.out.println("results.size()" + results.size());

        for (WebElement result : results) {
            System.out.println(result.getText());
        }
    }
}
