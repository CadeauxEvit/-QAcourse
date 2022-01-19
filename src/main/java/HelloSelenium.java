import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSelenium {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        String curentUrl = driver.getCurrentUrl();
        System.out.println("URL = " + curentUrl);
        String pageSource =driver.getPageSource();
        System.out.println("Source = " + pageSource);
        String tittle = driver.getTitle();
        System.out.println("Tittle = " + tittle);

        driver.navigate().to("https://yandex.ru/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
    }
}
