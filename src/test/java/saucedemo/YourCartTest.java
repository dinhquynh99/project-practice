package saucedemo;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.saucedemo.ProductsListPO;
import pageObjects.saucedemo.YourCartPO;

public class YourCartTest extends BaseTest {
    private WebDriver driver;
    private ProductsListPO productsListPage;
    private YourCartPO yourCartPage;

    @Parameters({"Browser", "Url"})
    @BeforeClass
    public void beforeClass(String browserName, String Url) {
        driver = getBrowserDriver(browserName, Url);

        productsListPage = loginAsValidUser();
        productsListPage.addItemToCartByIndex(0);
        productsListPage.addItemToCartByIndex(1);
        productsListPage.addItemToCartByIndex(2);
        productsListPage.sleepInSecond(2);

        yourCartPage = productsListPage.clickCartIcon();

    }

    @Test
    public void TC_O1_Verify_Header_Displayed() {
        Assert.assertTrue(yourCartPage.isHeaderLablelDisplay());
        Assert.assertEquals(yourCartPage.getCartItems().size(), 3);
    }

    @Test
    public void TC_02_Remote_Product_In_Your_Cart(){
        yourCartPage.remoteItemByIndex(0);

        Assert.assertEquals(yourCartPage.getCartItems().size(),2);
    }

    @Test
    public void TC_03_Continue_Shopping(){
        ProductsListPO productsListPage = yourCartPage.clickIconContinueShopping();

        Assert.assertTrue(productsListPage.isHeaderLabelDisplay());

    }


}
