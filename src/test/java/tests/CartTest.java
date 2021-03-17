package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests_data.TestData;

public class CartTest extends BaseTest {
    TestData testData = new TestData();

    @Test(description = "Checking on added product ing the cart", groups = {"smoke"})
    public void addProductInCartTest() {
        cartPage.openPage(PROMOTIONS_URL)
                .clickOnProduct(PROMOTION_PRODUCT)
                .clickToButtonInCart()
                .waitForPopUpIsDisplayed()
                .openPage(CART_URL);
        Assert.assertTrue(cartPage.checkProductAddedToCart(PROMOTION_PRODUCT));
    }

    @Test(description = "Checking checkout 'Самовывоз'", groups = {"smoke"})
    public void checkoutPickUpServiceTest() {
        cartPage.openPage(BASE_URL)
                .clickCatalogButton()
                .clickCatalogSection(GIFT_CERTIFICATE_SECTION_CATALOG)
                .clickOnProduct(GIFT_CERTIFICATE_PRODUCT)
                .clickToButtonInCart()
                .waitForPopUpIsDisplayed()
                .openPage(CART_URL)
                .clickToCheckoutButton()
                .inputUserData(testData.getUserData())
                .scrollToElement();
        Assert.assertTrue(cartPage.isCheckoutButtonDisplayed());
    }

    @Test(description = "Checking checkout 'Доставка по РБ'", groups = {"smoke"})
    public void checkoutDeliveryOnRBTest() {
        cartPage.openPage(BASE_URL)
                .clickCatalogButton()
                .clickCatalogSection(ANTISEPTICS_SECTION_CATALOG)
                .clickOnProduct(ANTISEPTICS_PRODUCT)
                .clickToButtonInCart()
                .waitForPopUpIsDisplayed()
                .openPage(CART_URL)
                .clickToCheckoutButton()
                .inputUserData(testData.getUserData())
                .clickCheckboxDeliveryOnRB()
                .inputAddressUserData(testData.getAddressUser());
        Assert.assertTrue(cartPage.isCheckoutButtonDisplayed());
    }
}
