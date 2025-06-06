package pages;

import actions.DeviceActions;
import actions.ElementActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private AndroidDriver driver;
    ElementActions elementActions;
    DeviceActions deviceActions;
    String accessibility="Accessibility";
    String animation="Animation";
    String app="App";
    String content="Content";
    String graphics="Graphics";
    String media="Media";
    String nfc="NFC";
    String os="OS";
    String preference="Preference";
    String text="Text";
    String views="Views";

    public HomePage(AndroidDriver driver){
        this.driver=driver;
        elementActions=new ElementActions(driver);
        deviceActions=new DeviceActions(driver);
    }
    public AccessibilityPage clickOnAccessibility(){
        elementActions.click(accessibility, ElementActions.Locators.accessibilityId);
        return new AccessibilityPage(driver);
    }
    public AnimationPage clickOnAnimation(){
        elementActions.click(animation, ElementActions.Locators.accessibilityId);
        return new AnimationPage(driver);
    }
    public AppPage clickOnApp(){
        elementActions.click(app, ElementActions.Locators.accessibilityId);
        return new AppPage(driver);
    }
    public ContentPage clickOnContent(){
        elementActions.click(content, ElementActions.Locators.accessibilityId);
        return new ContentPage(driver);
    }
    public GraphicsPage clickOnGraphics(){
        elementActions.click(graphics, ElementActions.Locators.accessibilityId);
        return new GraphicsPage(driver);
    }
    public MediaPage clickOnMedia(){
        elementActions.click(media, ElementActions.Locators.accessibilityId);
        return new MediaPage(driver);
    }
    public NFCPage clickOnNFC(){
        elementActions.click(nfc, ElementActions.Locators.accessibilityId);
        return new NFCPage(driver);
    }
    public OSPage clickOnOS(){
        elementActions.click(os, ElementActions.Locators.accessibilityId);
        return new OSPage(driver);
    }
    public PreferencePage clickOnPreference(){
        elementActions.click(preference, ElementActions.Locators.accessibilityId);
        return new PreferencePage(driver);
    }
    public TextPage clickOnText(){
        elementActions.click(text, ElementActions.Locators.accessibilityId);
        return new TextPage(driver);
    }
    public ViewsPage clickOnViews(){
        elementActions.click(views, ElementActions.Locators.accessibilityId);
        return new ViewsPage(driver);
    }
    public void navigateToHomePage() {
        while (true){
            List<WebElement> elements=driver.findElements(AppiumBy.className("android.widget.TextView"));
            for (WebElement element : elements) {
                if (element.isDisplayed() && "Accessibility".equals(element.getText())) {
                    return;
                }
            }
            deviceActions.pressKey(AndroidKey.BACK);
        }
    }
}
