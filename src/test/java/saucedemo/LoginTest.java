package saucedemo;

import core.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.saucedemo.LoginPO;
import pageObjects.saucedemo.ProductsListPO;

public class LoginTest extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private ProductsListPO productsListPage;
    String userName1, userName2, userName3, userName4, userName5, userName6, passwordForAll;

    @Parameters({"Browser", "Url"})
    @BeforeClass
    public void beforeClass(String browserName, String Url) {
        driver = getBrowserDriver(browserName, Url);
        userName1 = "standard_user";
        userName2 = "locked_out_user";
        userName3 = "problem_user";
        userName4 = "performance_glitch_user";
        userName5 = "error_user";
        userName6 = "visual_user";
        passwordForAll = "secret_sauce";

        loginPage = new LoginPO(driver);
    }


    @Test
    public void TC_01_Valid_Login() {
        loginPage.enterToUsernameTextbox(userName1);
        loginPage.enterToPasswordTextbox(passwordForAll);
        loginPage.clickToLoginButton();

        productsListPage = new ProductsListPO(driver);

        Assert.assertTrue(productsListPage.getPageURL(driver).contains("inventory.html"));

        productsListPage.clickToHamburgerMenu();
        productsListPage.sleepInSecond(2);

        productsListPage.clickToLogoutButton();
        productsListPage.sleepInSecond(2);

    }

    @Test
    public void TC_02_Invalid_Login_Wrong_username() {
        loginPage.enterToUsernameTextbox("wrong_user");
        loginPage.enterToPasswordTextbox(passwordForAll);
        loginPage.clickToLoginButton();

        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        loginPage.sleepInSecond(2);
        loginPage.clearUsernameTextbox();
        loginPage.clearPasswordTextbox();
    }

    @Test
    public void TC_03_Invalid_Login_Wrong_password() {
        loginPage.enterToUsernameTextbox(userName2);
        loginPage.enterToPasswordTextbox("wrong_password");
        loginPage.clickToLoginButton();

        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        loginPage.sleepInSecond(2);
        loginPage.clearUsernameTextbox();
        loginPage.clearPasswordTextbox();
    }

    @Test
    public void TC_04_Invalid_Login_Wrong_username_and_password() {
        loginPage.enterToUsernameTextbox("wrong_user");
        loginPage.enterToPasswordTextbox("wrong_password");
        loginPage.clickToLoginButton();

        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        loginPage.sleepInSecond(2);
        loginPage.clearUsernameTextbox();
        loginPage.clearPasswordTextbox();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
