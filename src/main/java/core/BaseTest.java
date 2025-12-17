package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import pageObjects.saucedemo.LoginPO;
import pageObjects.saucedemo.ProductsListPO;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;

    protected WebDriver getBrowserDriver(String browserName, String Url){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

        switch (browserList) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;

            default:
                throw new RuntimeException("Browser name is not valid!!!");
        }

        // driver.manage().window().setPosition(new Point(0,0));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(Url);
        return driver;
    }

    protected ProductsListPO loginAsValidUser() {
        LoginPO loginPage = new LoginPO(driver);
        loginPage.enterToUsernameTextbox("standard_user");
        loginPage.enterToPasswordTextbox("secret_sauce");
        loginPage.clickToLoginButton();
        return new ProductsListPO(driver);
    }

}
