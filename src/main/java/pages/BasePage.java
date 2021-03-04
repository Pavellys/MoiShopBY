package pages;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

abstract class BasePage implements Constants {
    WebDriver driver;
    Actions actions;

    BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

}
