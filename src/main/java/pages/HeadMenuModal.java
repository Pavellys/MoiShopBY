package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeadMenuModal extends BasePage{
    @FindBy(id = "catalog")
    WebElement catalogButton;
    @FindBy(id = "brands")
    WebElement brandsButton;
    @FindBy(className = "header-search-toggle")
    WebElement searchButton;
    @FindBy(className = "go-to-cart-link")
    WebElement cartButton;
    private static final String MENU_SECTION_XPATH = "//*[contains(text(),'%s')]";
    private static final By SEARCH_PANEL_CLASSNAME = By.id("multi-form");
    private static final By BRANDS_LIST_ID = By.id("ulBrands");
    private static final By CATALOG_LIST_ID = By.id("ctgr");
    private static final By MY_ACCOUNT_XPATH = By.xpath("//*[@alt='User']");
    private static final By BUTTON_ENTER_XPATH = By.xpath("//*[contains(text(),'Войти')]");

    public HeadMenuModal(WebDriver driver) {
        super(driver);
    }

    public HeadMenuModal openMoiShopBy() {
        driver.get(MAIN_URL);
        return this;
    }

    public HeadMenuModal clickToElementMenu(String nameSection){
        driver.findElement(By.xpath(String.format(MENU_SECTION_XPATH, nameSection))).click();
        return this;
    }

    public HeadMenuModal checkingCatalog(){
        catalogButton.click();
        return this;
    }

    public HeadMenuModal checkingBrands(){
        brandsButton.click();
        return this;
    }

    public HeadMenuModal clickingSearchButton(){
        searchButton.click();
        return this;
    }

    public HeadMenuModal checkingMyAccount(){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(MY_ACCOUNT_XPATH))
                .moveToElement(driver.findElement(BUTTON_ENTER_XPATH)).click();
        actions.build().perform();
        return this;
    }

    public HeadMenuModal checkingButtonCart(){
        cartButton.click();
        return this;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public boolean isCatalogDisplayed(){
        return driver.findElement(CATALOG_LIST_ID).isDisplayed();
    }

    public boolean isBrandsDisplayed(){
        return driver.findElement(BRANDS_LIST_ID).isDisplayed();
    }

    public boolean isSearchDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SEARCH_PANEL_CLASSNAME)));
        return driver.findElement(SEARCH_PANEL_CLASSNAME).isDisplayed();
    }
}
