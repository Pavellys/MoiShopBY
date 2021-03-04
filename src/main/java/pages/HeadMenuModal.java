package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HeadMenuModal extends BasePage{
    @FindBy(id = "catalog")
    WebElement catalog;
    @FindBy(id = "brands")
    WebElement brands;
    @FindBy(className = "header-search-toggle")
    WebElement search;
    @FindBy(className = "go-to-cart-link")
    WebElement buttonCart;
    private static final String MENU_SECTION = "//*[contains(text(),'%s')]";
    private static final By SEARCH_IS_DISPLAYED = By.className("multi-input");
    private static final By BRANDS_IS_DISPLAYED = By.id("ulBrands");
    private static final By CATALOG_IS_DISPLAYED = By.id("ctgr");

    public HeadMenuModal(WebDriver driver) {
        super(driver);
    }

    public HeadMenuModal openMoiShopBy() {
        driver.get(MAIN_URL);
        return this;
    }

    public HeadMenuModal clickToElementMenu(String nameSection){
        driver.findElement(By.xpath(String.format(MENU_SECTION, nameSection))).click();
        return this;
    }

    public HeadMenuModal checkingCatalog(){
        catalog.click();
        return this;
    }

    public HeadMenuModal checkingBrands(){
        brands.click();
        return this;
    }

    public HeadMenuModal checkingSearch(){
        search.click();
        return this;
    }

    public HeadMenuModal checkingMyAccount(){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(MY_ACCOUNT)).moveToElement(driver.findElement(BUTTON_ENTER)).click();
        actions.build().perform();
        return this;
    }

    public HeadMenuModal checkingButtonCart(){
        buttonCart.click();
        return this;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public boolean catalogIsDisplayed(){
        return driver.findElement(CATALOG_IS_DISPLAYED).isDisplayed();
    }

    public boolean brandsIsDisplayed(){
        return driver.findElement(BRANDS_IS_DISPLAYED).isDisplayed();
    }

    public boolean searchIsDisplayed(){
        return driver.findElement(SEARCH_IS_DISPLAYED).isDisplayed();
    }
}
