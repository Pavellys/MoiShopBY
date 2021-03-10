package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeadMenuTest extends BaseTest {

    @Test(description = "Checking redirect on menu section 'О компании'", groups = {"critical_pass"})
    public void aboutCompanyTest() {
        headMenuModal.openMoiShopBy()
                .clickToElementMenu(ABOUT_COMPANY);
        Assert.assertEquals(headMenuModal.getCurrentUrl(), ABOUT_COMPANY_URL);
    }

    @Test(description = "Checking redirect on menu section 'Акции'", groups = {"smoke"})
    public void promotionsTest() {
        headMenuModal.openMoiShopBy()
                .clickToElementMenu(PROMOTIONS);
        Assert.assertEquals(headMenuModal.getCurrentUrl(), PROMOTIONS_URL);
    }

    @Test(description = "Checking redirect on menu section 'Оплата и Доставка'", groups = {"smoke"})
    public void paymentAndDeliveryTest() {
        headMenuModal.openMoiShopBy()
                .clickToElementMenu(PAYMENT_AND_DELIVERY);
        Assert.assertEquals(headMenuModal.getCurrentUrl(), PAYMENT_AND_DELIVERY_URL);
    }

    @Test(description = "Checking redirect on menu section 'Контакты'", groups = {"critical_pass"})
    public void contactsTest() {
        headMenuModal.openMoiShopBy()
                .clickToElementMenu(CONTACTS);
        Assert.assertEquals(headMenuModal.getCurrentUrl(), CONTACTS_URL);
    }

    @Test(description = "Checking redirect on menu section 'Отзывы'", groups = {"critical_pass"})
    public void feedbacksTest() {
        headMenuModal.openMoiShopBy()
                .clickToElementMenu(FEEDBACKS);
        Assert.assertEquals(headMenuModal.getCurrentUrl(), FEEDBACKS_URL);
    }

    @Test(description = "Checking redirect on menu section 'Каталог'", groups = {"smoke"})
    public void catalogTest() {
        headMenuModal.openMoiShopBy()
                .checkingCatalog();
        Assert.assertTrue(headMenuModal.isCatalogDisplayed());
    }

    @Test(description = "Checking redirect on menu section 'Бренды'", groups = {"smoke"})
    public void brandsTest() {
        headMenuModal.openMoiShopBy()
                .checkingBrands();
        Assert.assertTrue(headMenuModal.isBrandsDisplayed());
    }

    @Test(description = "Checking redirect on menu section 'Поиск'", groups = {"critical_pass"})
    public void searchTest() {
        headMenuModal.openMoiShopBy()
                .checkingSearch();
        Assert.assertTrue(headMenuModal.isSearchDisplayed());
    }

    @Test(description = "Checking redirect on menu section 'Мой аккаунт'", groups = {"critical_pass"})
    public void myAccountTest() {
        headMenuModal.openMoiShopBy()
                .checkingMyAccount();
        Assert.assertEquals(headMenuModal.getCurrentUrl(), ACCOUNT_URL);
    }

    @Test(description = "Checking redirect on menu section 'Корзина'", groups = {"smoke"})
    public void buttonCartTest() {
        headMenuModal.openMoiShopBy()
                .checkingButtonCart();
        Assert.assertEquals(headMenuModal.getCurrentUrl(), CART_URL);
    }
}
