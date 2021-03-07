package tests;

import objects.AddressUser;
import objects.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CartTest extends BaseTest {
    UserData userData = new UserData("Pavel", "3333856769");
    AddressUser addressUser = new AddressUser("Брест", "210110", "Брестская",
            "Брестский", "Папанина", "22", "1", "22", "2", "1");

    @Test
    public void addPromProductInCartTest() {
        cartPage.openPage(PROMOTIONS_URL)
                .clickToProduct(PROMOTION_PRODUCT)
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
                .clickToProduct(GIFT_CERTIFICATE_PRODUCT)
                .clickToButtonInCart()
                .isPopUpDisplayed()
                .openPage(CART_URL)
                .clickToCheckoutButton()
                .inputUserData(userData)
                .scrollDown();
        Assert.assertTrue(cartPage.isCheckoutButtonDisplayed());
    }

    @Test
    public void checkoutDeliveryOnRBTest() {
        cartPage.openPage(BASE_URL)
                .clickCatalog()
                .clickCatalogSection(ANTISEPTICS_SECTION_CATALOG)
                .clickToProduct(ANTISEPTICS_PRODUCT)
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
