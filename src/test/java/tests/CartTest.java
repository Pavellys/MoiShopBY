package tests;

import objects.AddressUser;
import objects.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CartTest extends BaseTest {

    @Test
    public void addProductInCartTest() {
        cartPage.openPage(PROMOTIONS_URL)
                .clickOnProduct(PROMOTION_PRODUCT)
                .clickToButtonInCart()
                .isPopUpDisplayed()
                .openPage(CART_URL);
        Assert.assertTrue(cartPage.checkInCart(PROMOTION_PRODUCT));
    }

    @Test
    public void checkoutPickUpServiceTest() {
        cartPage.openPage(BASE_URL)
                .clickCatalog()
                .clickCatalogSection(GIFT_CERTIFICATE_SECTION_CATALOG)
                .clickOnProduct(GIFT_CERTIFICATE_PRODUCT)
                .clickToButtonInCart()
                .isPopUpDisplayed()
                .openPage(CART_URL)
                .clickToCheckoutButton()
                .inputUserData(userData)
                .scrollToElement();
        Assert.assertTrue(cartPage.isCheckoutButtonDisplayed());
    }

    @Test
    public void checkoutDeliveryOnRBTest() {
        cartPage.openPage(BASE_URL)
                .clickCatalog()
                .clickCatalogSection(ANTISEPTICS_SECTION_CATALOG)
                .clickOnProduct(ANTISEPTICS_PRODUCT)
                .clickToButtonInCart()
                .isPopUpDisplayed()
                .openPage(CART_URL)
                .clickToCheckoutButton()
                .inputUserData(userData)
                .clickCheckboxDeliveryOnRB()
                .inputAddressUserData(addressUser);
        Assert.assertTrue(cartPage.isCheckoutButtonDisplayed());
    }
}
