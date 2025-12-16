package pageObjects.saucedemo;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageUIs.saucedemo.LoginPageUI;

import static pageUIs.saucedemo.LoginPageUI.ERROR_MESSAGE;

public class LoginPO extends BasePage {
    private WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUsernameTextbox(String userName) {
        waitElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, userName);

    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToLoginButton() {
        waitElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

    public boolean isErrorMessageDisplayed() {
        waitElementVisible(driver, LoginPageUI.ERROR_MESSAGE);
        return isElementDisplayed(driver, LoginPageUI.ERROR_MESSAGE);
    }

    public void clearUsernameTextbox() {
        waitElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        clearElement(driver, LoginPageUI.USERNAME_TEXTBOX);
    }

    public void clearPasswordTextbox() {
        waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        clearElement(driver, LoginPageUI.PASSWORD_TEXTBOX);
    }


}


