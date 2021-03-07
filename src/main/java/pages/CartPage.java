package pages;

import elements.Input;
import objects.AddressUser;
import objects.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
    @FindBy(id = "catalog")
    WebElement catalogButton;
    @FindBy(id = "btnShowCheckoutForm")
    WebElement checkoutButton;
    @FindBy(xpath = "//*[contains(@Class,'add-to-cart')]")
    WebElement cartButton;
    @FindBy(xpath = "//*[contains(@Class,'ajs-message')]")
    WebElement popUp;
    @FindBy(id = "checkout")
    WebElement checkoutButtonEndOrder;
    @FindBy(xpath = "//*[@for='shipping_address']")
    WebElement checkboxDeliveryOnRB;
    private static final String FIND_ITEM_BY_TEXT_XPATH = "//*[contains(text(),'%s')]";
    private static final String FIND_ITEM_IN_CART_XPATH = "//*[@class='cart-main-item']//*[contains(text(), '%s')]";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public CartPage clickOnProduct(String productName){
        driver.findElement(By.xpath(String.format(FIND_ITEM_BY_TEXT_XPATH, productName))).click();
        return this;
    }

    public CartPage clickToButtonInCart() {
        cartButton.click();
        return this;
    }

    public CartPage isPopUpDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(popUp)).isDisplayed();
        return this;
    }


    public boolean checkInCart(String productInCart){
        return driver.findElement(By.xpath(String.format(FIND_ITEM_IN_CART_XPATH, productInCart))).isDisplayed();
    }

    public CartPage clickToCheckoutButton(){
        checkoutButton.click();
        return this;
    }

    public CartPage clickCatalogSection(String section){
        driver.findElement(By.xpath(String.format(FIND_ITEM_BY_TEXT_XPATH, section))).click();
        return this;
    }

    public CartPage clickCatalog(){
        catalogButton.click();
        return this;
    }

    public CartPage inputUserData(UserData userData){
        new Input(driver, "fullname").write(userData.getFullName());
        new Input(driver, "phone-mask").write(userData.getPhone_mask());
        return this;
    }

    public CartPage scrollToElement(){
        executeJavaScript("arguments[0].scrollIntoView(true);", checkoutButtonEndOrder, driver);
        return this;
    }

    public boolean isCheckoutButtonDisplayed(){
        return checkoutButtonEndOrder.isDisplayed();
    }

    public CartPage clickCheckboxDeliveryOnRB(){
        checkboxDeliveryOnRB.click();
        return this;
    }

    public CartPage inputAddressUserData(AddressUser addressUser){
        new Input(driver, "shipCity").write(addressUser.getShipCity());
        new Input(driver, "shipZipсode").write(addressUser.getShipZipCode());
        new Input(driver, "shipRegion").write(addressUser.getShipRegion());
        new Input(driver, "shipDistrict").write(addressUser.getShipDistrict());
        new Input(driver, "shipStreet").write(addressUser.getShipStreet());
        new Input(driver, "shipHouse").write(addressUser.getShipHouse());
        new Input(driver, "shipBuilding").write(addressUser.getShipBuilding());
        new Input(driver, "shipAppt").write(addressUser.getShipAppt());
        new Input(driver, "shipEntrance").write(addressUser.getShipEntrance());
        new Input(driver, "shipFloor").write(addressUser.getShipFloor());
        return this;
    }
}
