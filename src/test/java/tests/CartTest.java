package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "Checking on added product ing the cart")
    public void addProductInCartTest() {
        cartPage.openPage(PROMOTIONS_URL)
                .clickOnProduct(PROMOTION_PRODUCT)
                .clickToButtonInCart()
                .isPopUpDisplayed()
                .openPage(CART_URL);
        Assert.assertTrue(cartPage.checkInCart(PROMOTION_PRODUCT));
    }

    @Test(description = "Checking checkout 'Самовывоз'")
    public void checkoutPickUpServiceTest() {
        cartPage.openPage(BASE_URL)
                .clickCatalog()
                .clickCatalogSection(GIFT_CERTIFICATE_SECTION_CATALOG)
                .clickOnProduct(GIFT_CERTIFICATE_PRODUCT)
                .clickToButtonInCart()
                .isPopUpDisplayed()
                .openPage(CART_URL)
                .clickToCheckoutButton()
                .inputUserData(getUserData())
                .scrollToElement();
        Assert.assertTrue(cartPage.isCheckoutButtonDisplayed());
    }

    @Test(description = "Checking checkout 'Доставка по РБ'")
    public void checkoutDeliveryOnRBTest() {
        cartPage.openPage(BASE_URL)
                .clickCatalog()
                .clickCatalogSection(ANTISEPTICS_SECTION_CATALOG)
                .clickOnProduct(ANTISEPTICS_PRODUCT)
                .clickToButtonInCart()
                .isPopUpDisplayed()
                .openPage(CART_URL)
                .clickToCheckoutButton()
                .inputUserData(getUserData())
                .clickCheckboxDeliveryOnRB()
                .inputAddressUserData(getAddressUser());
        Assert.assertTrue(cartPage.isCheckoutButtonDisplayed());
    }
}