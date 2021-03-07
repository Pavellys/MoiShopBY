package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeadMenuTest extends BaseTest{

    @Test
    public void aboutCompanyTest(){
        headMenuModal.openMoiShopBy()
                .clickToElementMenu(ABOUT_COMPANY);
        Assert.assertEquals(headMenuModal.getCurrentUrl(), ABOUT_COMPANY_URL);
    }

    @Test
    public void promotionsTest(){
        headMenuModal.openMoiShopBy()
                .clickToElementMenu(PROMOTIONS);
        Assert.assertEquals(headMenuModal.getCurrentUrl(), PROMOTIONS_URL);
    }

    @Test
    public void paymentAndDeliveryTest(){
        headMenuModal.openMoiShopBy()
                .clickToElementMenu(PAYMENT_AND_DELIVERY);
        Assert.assertEquals(headMenuModal.getCurrentUrl(), PAYMENT_AND_DELIVERY_URL);
    }

    @Test
    public void contactsTest(){
        headMenuModal.openMoiShopBy()
                .clickToElementMenu(CONTACTS);
        Assert.assertEquals(headMenuModal.getCurrentUrl(), CONTACTS_URL);
    }

    @Test
    public void feedbacksTest(){
        headMenuModal.openMoiShopBy()
                .clickToElementMenu(FEEDBACKS);
        Assert.assertEquals(headMenuModal.getCurrentUrl(), FEEDBACKS_URL);
    }

    @Test
    public void catalogTest(){
        headMenuModal.openMoiShopBy()
                .checkingCatalog();
        Assert.assertTrue(headMenuModal.isCatalogDisplayed());
    }

    @Test
    public void brandsTest(){
        headMenuModal.openMoiShopBy()
                .checkingBrands();
        Assert.assertTrue(headMenuModal.isBrandsDisplayed());
    }

    @Test
    public void searchTest(){
        headMenuModal.openMoiShopBy()
                .checkingSearch();
        Assert.assertTrue(headMenuModal.isSearchDisplayed());
    }

    @Test
    public void myAccountTest(){
        headMenuModal.openMoiShopBy()
                .checkingMyAccount();
        Assert.assertEquals(headMenuModal.getCurrentUrl(), ACCOUNT_URL);
    }

    @Test
    public void buttonCartTest(){
        headMenuModal.openMoiShopBy()
                .checkingButtonCart();
        Assert.assertEquals(headMenuModal.getCurrentUrl(), CART_URL);
    }
}
