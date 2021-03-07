package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeadMenuTest extends BaseTest{

    @Test
    public void aboutCompanyTest(){
        headMenuModal.openMoiShopBy(BASE_URL)
                .clickToElementMenu(ABOUT_COMPANY);
        Assert.assertEquals(headMenuModal.getCurrentUrl(), ABOUT_COMPANY_URL);
    }

    @Test
    public void promotionsTest(){
        headMenuModal.openMoiShopBy(BASE_URL)
                .clickToElementMenu(PROMOTIONS);
        Assert.assertEquals(headMenuModal.getCurrentUrl(), PROMOTIONS_URL);
    }

    @Test
    public void paymentAndDeliveryTest(){
        headMenuModal.openMoiShopBy(BASE_URL)
                .clickToElementMenu(PAYMENT_AND_DELIVERY);
        Assert.assertEquals(headMenuModal.getCurrentUrl(), PAYMENT_AND_DELIVERY_URL);
    }

    @Test
    public void contactsTest(){
        headMenuModal.openMoiShopBy(BASE_URL)
                .clickToElementMenu(CONTACTS);
        Assert.assertEquals(headMenuModal.getCurrentUrl(), CONTACTS_URL);
    }

    @Test
    public void feedbacksTest(){
        headMenuModal.openMoiShopBy(BASE_URL)
                .clickToElementMenu(FEEDBACKS);
        Assert.assertEquals(headMenuModal.getCurrentUrl(), FEEDBACKS_URL);
    }

    @Test
    public void catalogTest(){
        headMenuModal.openMoiShopBy(BASE_URL)
                .checkingCatalog();
        Assert.assertTrue(headMenuModal.isCatalogDisplayed());
    }

    @Test
    public void brandsTest(){
        headMenuModal.openMoiShopBy(BASE_URL)
                .checkingBrands();
        Assert.assertTrue(headMenuModal.isBrandsDisplayed());
    }

    @Test
    public void searchTest(){
        headMenuModal.openMoiShopBy(BASE_URL)
                .checkingSearch();
        Assert.assertTrue(headMenuModal.isSearchDisplayed());
    }

    @Test
    public void myAccountTest(){
        headMenuModal.openMoiShopBy(BASE_URL)
                .checkingMyAccount();
        Assert.assertEquals(headMenuModal.getCurrentUrl(), ACCOUNT_URL);
    }

    @Test
    public void buttonCartTest(){
        headMenuModal.openMoiShopBy(BASE_URL)
                .checkingButtonCart();
        Assert.assertEquals(headMenuModal.getCurrentUrl(), CART_URL);
    }
}
