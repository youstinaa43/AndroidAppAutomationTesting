package actions;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class ElementActions {
    private AndroidDriver driver;
    public WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement getWebElement(String selector,Locators locator){
        WebElement element;
        switch (locator){
            case id:
                element=  driver.findElement(AppiumBy.id(selector));
                break;
            case xpath:
                element=driver.findElement(AppiumBy.xpath(selector));
                break;
            case accessibilityId:
                element= driver.findElement(AppiumBy.accessibilityId(selector));
                break;
            case androidUIAutomator:
                element=driver.findElement(AppiumBy.androidUIAutomator(selector));
                break;
            default:
                throw new IllegalArgumentException("Unsupported locator type: " + locator);
        }
        return element;
    }
    public void click(String selector,Locators locator){
        By element;
        switch (locator){
            case id:
                element=  AppiumBy.id(selector);
                break;
            case xpath:
                element=  AppiumBy.xpath(selector);
                break;
            case accessibilityId:
                element=  AppiumBy.accessibilityId(selector);
                break;
            case androidUIAutomator:
                element= AppiumBy.androidUIAutomator(selector);
                break;
            default:
                throw new IllegalArgumentException("Unsupported locator type: " + locator);
        }
        waitForElement(element).click();
    }
    public String getElementText(String selector,Locators locator){
        By element;
        switch (locator){
            case id:
                element=  AppiumBy.id(selector);
                break;
            case xpath:
                element=  AppiumBy.xpath(selector);
                break;
            case accessibilityId:
                element=  AppiumBy.accessibilityId(selector);
                break;
            case androidUIAutomator:
                element= AppiumBy.androidUIAutomator(selector);
                break;
            default:
                throw new IllegalArgumentException("Unsupported locator type: " + locator);
        }
        return waitForElement(element).getText();
    }
    public boolean isCheckboxChecked(String selector, Locators locator) {
        By elementLocator;
        switch (locator) {
            case id:
                elementLocator = AppiumBy.id(selector);
                break;
            case xpath:
                elementLocator = AppiumBy.xpath(selector);
                break;
            case accessibilityId:
                elementLocator = AppiumBy.accessibilityId(selector);
                break;
            case androidUIAutomator:
                elementLocator = AppiumBy.androidUIAutomator(selector);
                break;
            default:
                throw new IllegalArgumentException("Unsupported locator type: " + locator);
        }

        WebElement checkbox = waitForElement(elementLocator);
        String isChecked = checkbox.getAttribute("checked");
        return isChecked != null && isChecked.equalsIgnoreCase("true");
    }
    public void sendKeys(String selector, Locators locator, String text) {
        By elementLocator;
        switch (locator) {
            case id:
                elementLocator = AppiumBy.id(selector);
                break;
            case xpath:
                elementLocator = AppiumBy.xpath(selector);
                break;
            case accessibilityId:
                elementLocator = AppiumBy.accessibilityId(selector);
                break;
            case androidUIAutomator:
                elementLocator = AppiumBy.androidUIAutomator(selector);
                break;
            default:
                throw new IllegalArgumentException("Unsupported locator type: " + locator);
        }

        WebElement element = waitForElement(elementLocator);
        element.clear();
        element.sendKeys(text);
    }
    public ElementActions(AndroidDriver driver){
        this.driver=driver;
    }
    public void longPressAction(WebElement element){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
                        "duration",2000));
    }
    public void scrollToEndAction(){
        boolean canScrollMore;
        do{
            canScrollMore=(Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of(
                            "left",100, "top",100, "width",200,"height",200,
                            "direction","down","percent",3.0
                    ));
        }while (canScrollMore);
    }
    public void swipeAction(WebElement element, String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of(
                        "elementId",((RemoteWebElement)element).getId(),
                        "direction",direction,"percent",0.75
                ));
    }
    public void dragDropAction(WebElement element){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
                ImmutableMap.of(
                        "elementId",((RemoteWebElement)element).getId(),
                        "endX",665,"endY",585
                ));
    }


    public enum Locators{
        id,
        accessibilityId,
        xpath,
        androidUIAutomator
    }
}
