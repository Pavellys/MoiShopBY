package pages;


import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

@Log4j2
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
    private static final By SEARCH_PANEL_CLASSNAME = By.className("multi-input");
    private static final By BRANDS_LIST_ID = By.id("ulBrands");
    private static final By CATALOG_LIST_ID = By.id("ctgr");
    private static final By MY_ACCOUNT_XPATH = By.xpath("//*[@alt='User']");
    private static final By BUTTON_ENTER_XPATH = By.xpath("//*[contains(text(),'Войти')]");

    public HeadMenuModal(WebDriver driver) {
        super(driver);
    }

    @Step("Opening page " + MAIN_URL)
    public HeadMenuModal openMoiShopBy() {
        log.info("Opening page " + MAIN_URL);
        driver.get(MAIN_URL);
        return this;
    }

    @Step("Clicking on menu section")
    public HeadMenuModal clickToElementMenu(String nameSection){
        log.info("Clicking on menu section " + nameSection);
        driver.findElement(By.xpath(String.format(MENU_SECTION_XPATH, nameSection))).click();
        return this;
    }

    @Step("Clicking on button 'Каталог'")
    public HeadMenuModal checkingCatalog(){
        log.info("Clicking on button 'Каталог'");
        catalogButton.click();
        return this;
    }

    @Step("Clicking on button 'Бренды'")
    public HeadMenuModal checkingBrands(){
        log.info("Clicking on button 'Бренды'");
        brandsButton.click();
        return this;
    }

    @Step("Clicking on button 'Поиск'")
    public HeadMenuModal checkingSearch(){
        log.info("Clicking on button 'Поиск'");
        searchButton.click();
        return this;
    }

    @Step("Clicking on button 'Войти' in menu section 'Моц аккаунт'")
    public HeadMenuModal checkingMyAccount(){
        log.info("Clicking on button 'Войти' in menu section 'Моц аккаунт'");
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(MY_ACCOUNT_XPATH))
                .moveToElement(driver.findElement(BUTTON_ENTER_XPATH)).click();
        actions.build().perform();
        return this;
    }

    @Step("Clicking on button 'Корзина'")
    public HeadMenuModal checkingButtonCart(){
        log.info("Clicking on button 'Корзина'");
        cartButton.click();
        return this;
    }

    @Step("Getting current url")
    public String getCurrentUrl(){
        log.info("Getting current url");
        return driver.getCurrentUrl();
    }

    @Step("Checking that list catalog is displayed")
    public boolean isCatalogDisplayed(){
        log.info("Checking that list catalog is displayed");
        return driver.findElement(CATALOG_LIST_ID).isDisplayed();
    }

    @Step("Checking that list brands is displayed")
    public boolean isBrandsDisplayed(){
        log.info("Checking that list brands is displayed");
        return driver.findElement(BRANDS_LIST_ID).isDisplayed();
    }

    @Step("Checking that search panel is displayed")
    public boolean isSearchDisplayed(){
        log.info("Checking that search panel is displayed");
        return driver.findElement(SEARCH_PANEL_CLASSNAME).isDisplayed();
    }
}
