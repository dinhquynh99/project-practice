package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public static BasePage getBasePage(){
        return new BasePage();
    }

    public void openPageURL(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    private By getByXpath(String locator) {
        return By.xpath(locator);
    }

    private WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByXpath(locator));
    }

    public void sendkeyToElement(WebDriver driver, String locator, String valueToSend) {
        getElement(driver, locator).sendKeys(valueToSend);
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void clearElement(WebDriver driver, String locator){
        getElement(driver, locator).clear();
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public WebElement waitElementVisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public WebElement waitElementClickable(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Duration shortTimeout = Duration.ofSeconds(10);
    private Duration longTimeout = Duration.ofSeconds(30);

}
