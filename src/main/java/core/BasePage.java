package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    private By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public String getElementCss(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getDomProperty(propertyName);
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    protected WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByXpath(locator));
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public List<WebElement> getListElement(WebDriver driver, String locator) {
        return driver.findElements(getByXpath(locator));
    }

    public int getListElementSize(WebDriver driver, String locator) {
        return getListElement(driver, locator).size();
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

    public void selectItemInDropdown(WebDriver driver, String locator, String textItem) {
        Select select = new Select(getElement(driver, locator));
        select.selectByVisibleText(textItem);
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
