package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CartPage;
import pages.HeadMenuModal;
import tests_constants.ITestConstants;
import tests_data.TestData;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest extends TestData implements ITestConstants {

    WebDriver driver;
    HeadMenuModal headMenuModal;
    CartPage cartPage;

    @BeforeMethod
    public void initTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPage();
    }

    @AfterMethod(alwaysRun = true)
    public void endTest(){
        driver.quit();
    }

    public void initPage(){
       headMenuModal = new HeadMenuModal(driver);
       cartPage = new CartPage(driver);
    }
}
