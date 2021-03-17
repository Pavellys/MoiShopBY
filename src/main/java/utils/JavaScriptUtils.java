package utils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CartPage;


public class JavaScriptUtils{
    public static void executeJavaScript(String scriptToExecute, WebElement locator, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript(scriptToExecute, locator);
    }

    public static void scrollToElement(WebElement locator, WebDriver driver){
        JavaScriptUtils.executeJavaScript("arguments[0].scrollIntoView(true);", locator, driver);
    }
}
