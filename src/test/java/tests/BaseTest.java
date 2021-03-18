package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.CartPage;
import pages.HeadMenuModal;
import tests_constants.ITestConstants;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest implements ITestConstants {

    WebDriver driver;
    HeadMenuModal headMenuModal;
    CartPage cartPage;

    @BeforeMethod(groups = "init")
    public void initTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        initPage();
    }

    @AfterMethod(alwaysRun = true, groups = "init")
    public void endTest(){
        driver.quit();
    }

    public void initPage(){
       headMenuModal = new HeadMenuModal(driver);
       cartPage = new CartPage(driver);
    }
}
