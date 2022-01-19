package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.AboutPage;
import pageObjects.AccountPage;
import pageObjects.Urls;

public class FillNewCustomerTest {
    public static void main(String[] args) {
        //Create Webdriver

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Urls.BASE_URL);

        //About Page
        AboutPage aboutPage = new AboutPage(driver);
        aboutPage.sleep(2000);
        aboutPage.clickNext();
        Assert.assertEquals(aboutPage.getFirstNameError(),"This field is required.", "Error message is incorrect");
        Assert.assertEquals(aboutPage.getLastNameError(),"This field is required.", "Error message is incorrect");
        Assert.assertEquals(aboutPage.getEmailError(),"This field is required.", "Error message is incorrect");

        aboutPage.fillForm("Erika", "Markov", "erik.mar@gmail.com");
        aboutPage.clickNext();
        //Account Page
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.accountPageIsDisplayed(), "Account page was not displayed");
        accountPage.sleep(2000);
        accountPage.clickIcons();
        accountPage.clickNext();
        accountPage.sleep(2000);

        aboutPage.tearDown();
    }
}
