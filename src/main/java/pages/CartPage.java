package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import objects.AddressUser;
import objects.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.JavaScriptUtils;

@Log4j2
public class CartPage extends BasePage{
    @FindBy(id = "catalog")
    WebElement catalogButton;
    @FindBy(id = "btnShowCheckoutForm")
    WebElement checkoutButton;
    @FindBy(xpath = "//*[contains(@class,'add-to-cart')]")
    WebElement cartButton;
    @FindBy(xpath = "//*[contains(@class,'ajs-message')]")
    WebElement popUp;
    @FindBy(id = "checkout")
    WebElement checkoutButtonEndOrder;
    @FindBy(xpath = "//*[contains(text(), 'Доставка по РБ')]")
    WebElement checkboxDeliveryOnRB;
    private static final String FIND_ITEM_BY_TEXT_XPATH = "//*[contains(text(),'%s')]";
    private static final String FIND_ITEM_IN_CART_XPATH = "//*[@class='cart-main-item']//*[contains(text(), '%s')]";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening page: " + MAIN_URL)
    public CartPage openPage(String url) {
        log.info("Opening page: " + url);
        driver.get(url);
        return this;
    }

    @Step("Clicking on product")
    public CartPage clickOnProduct(String productName){
        log.info("Clicking on product: " + productName);
        driver.findElement(By.xpath(String.format(FIND_ITEM_BY_TEXT_XPATH, productName))).click();
        return this;
    }

    @Step("Clicking on button 'В корзину'")
    public CartPage clickToButtonInCart() {
        log.info("Clicking on button 'В корзину'");
        cartButton.click();
        return this;
    }

    @Step("Waiting until visibility of pop-up massage")
    public CartPage isPopUpDisplayed(){
        log.info("Waiting until visibility of pop-up massage");
        wait.until(ExpectedConditions.visibilityOf(popUp)).isDisplayed();
        return this;
    }

    @Step("Checking that product added in cart")
    public boolean isProductInCart(String productInCart){
        log.info("Checking that " + productInCart + " added in cart");
        return driver.findElement(By.xpath(String.format(FIND_ITEM_IN_CART_XPATH, productInCart))).isDisplayed();
    }

    @Step("Clicking on button 'Оформить заказ'")
    public CartPage clickToCheckoutButton(){
        log.info("Clicking on button 'Оформить заказ'");
        checkoutButton.click();
        return this;
    }

    @Step("Clicking on catalog section")
    public CartPage clickCatalogSection(String section){
        log.info("Clicking on catalog section " + section);
        driver.findElement(By.xpath(String.format(FIND_ITEM_BY_TEXT_XPATH, section))).click();
        return this;
    }

    @Step("Clicking on button 'Каталог'")
    public CartPage clickCatalog(){
        log.info("Clicking on button 'Каталог'");
        catalogButton.click();
        return this;
    }

    @Step("Entering data in fields 'Имя Фамилия' and 'Номер телефона' ")
    public CartPage inputUserData(UserData userData){
        log.info("Entering data in fields 'Имя Фамилия'" + userData.getFullName() + " and 'Номер телефона' "
        + userData.getPhone_mask());
        new Input(driver, "fullname").write(userData.getFullName());
        new Input(driver, "phone-mask").write(userData.getPhone_mask());
        return this;
    }

    @Step("Scrolling page to button 'Заказать'")
    public CartPage scrollToElement(){
        log.info("Scrolling page to button 'Заказать'");
        JavaScriptUtils.executeJavaScript("arguments[0].scrollIntoView(true);", checkoutButtonEndOrder, driver);
        return this;
    }

    @Step("Checking that button 'Заказать' in end order is displayed")
    public boolean isButtonDisplayed(){
        log.info("Checking that button 'Заказать' in end order is displayed");
        return checkoutButtonEndOrder.isDisplayed();
    }

    @Step("Clicking in checkbox 'Доставка по РБ'")
    public CartPage clickCheckboxDeliveryOnRB(){
        log.info("Clicking in checkbox 'Доставка по РБ'");
        checkboxDeliveryOnRB.click();
        return this;
    }

    @Step("Entering data in address form 'Доставка по РБ'")
    public CartPage inputAddressUserData(AddressUser userAddress){
        log.info("Entering address: " + userAddress +" in address form 'Доставка по РБ'");
        new Input(driver, "shipCity").write(userAddress.getShipCity());
        new Input(driver, "shipZipсode").write(userAddress.getShipZipCode());
        new Input(driver, "shipRegion").write(userAddress.getShipRegion());
        new Input(driver, "shipDistrict").write(userAddress.getShipDistrict());
        new Input(driver, "shipStreet").write(userAddress.getShipStreet());
        new Input(driver, "shipHouse").write(userAddress.getShipHouse());
        new Input(driver, "shipBuilding").write(userAddress.getShipBuilding());
        new Input(driver, "shipAppt").write(userAddress.getShipAppt());
        new Input(driver, "shipEntrance").write(userAddress.getShipEntrance());
        new Input(driver, "shipFloor").write(userAddress.getShipFloor());
        return this;
    }
}
