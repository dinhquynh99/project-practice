package pageObjects.saucedemo;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.saucedemo.LoginPageUI;
import pageUIs.saucedemo.ProductsListUI;

public class ProductsListPO extends BasePage {
    private WebDriver driver;

    public ProductsListPO (WebDriver driver) {
        this.driver = driver;
    }

    public void clickToHamburgerMenu() {
        waitElementClickable(driver, ProductsListUI.HAMBURGER_MENU);
        clickToElement(driver, ProductsListUI.HAMBURGER_MENU);
    }

    public void clickToLogoutButton() {
        waitElementClickable(driver, ProductsListUI.LOGOUT_BUTTON);
        clickToElement(driver, ProductsListUI.LOGOUT_BUTTON);
    }
}
