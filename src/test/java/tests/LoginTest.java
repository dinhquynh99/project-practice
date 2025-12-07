package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTest {

        private WebDriver driver;
        private LoginPage loginPage;

        @BeforeClass
        public void setup() {
                driver = new ChromeDriver();
                driver.manage().window().maximize();

                loginPage = new LoginPage(driver);
        }

        @Test
        public void testValidLogin() {
                loginPage.openUrl("https://www.saucedemo.com/");

                loginPage.login("standard_user", "secret_sauce");

                Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                        "Login failed! Expected inventory page.");
        }

        @Test
        public void testInvalidLogin() {
                loginPage.openUrl("https://www.saucedemo.com/");

                loginPage.login("wrong_user", "wrong_pass");

                Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"),
                        "Error message is incorrect.");
        }

        @AfterClass
        public void tearDown() {
                driver.quit();
        }
}
