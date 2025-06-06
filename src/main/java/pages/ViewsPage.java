package pages;

import actions.ElementActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ViewsPage {
    AndroidDriver driver;
    ElementActions elementActions;
    String dragDrop="Drag and Drop";
    String dragDropSource="io.appium.android.apis:id/drag_dot_1";
    String droppedText="io.appium.android.apis:id/drag_result_text";
    String expandableLists="Expandable Lists";
    String expenCustomAdapter="1. Custom Adapter";
    String peopleNames="//android.widget.TextView[@text=\"People Names\"]";
    String sampleMenu="android:id/title";
    String gallery="Gallery";
    String galleryPhotos="1. Photos";
    String galleryFirstPhotos="(//android.widget.ImageView)[1]";
    String webView="new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));";
    public ViewsPage(AndroidDriver driver){
        this.driver=driver;
        elementActions=new ElementActions(driver);
    }
    public void clickOnDragDrop(){
        elementActions.click(dragDrop, ElementActions.Locators.accessibilityId);
    }
    public void dragAndDrop(){
        WebElement element=driver.findElement(AppiumBy.id(dragDropSource));
        elementActions.dragDropAction(element);
    }
    public String getDroppedText(){
        return elementActions.getElementText(droppedText, ElementActions.Locators.id);
    }
    public void clickOnExpandableLists(){
        elementActions.click(expandableLists, ElementActions.Locators.accessibilityId);
    }
    public void clickOnExpandCustomAdapter(){
        elementActions.click(expenCustomAdapter, ElementActions.Locators.accessibilityId);
    }
    public void longPressOnPeopleNames(){
        WebElement element=driver.findElement(AppiumBy.xpath(peopleNames));
        elementActions.longPressAction(element);
    }
    public String getSampleMenuText(){
        return elementActions.getElementText(sampleMenu, ElementActions.Locators.id);
    }
    public boolean isSampleMenuDisplayed(){
        return driver.findElement(AppiumBy.id(sampleMenu)).isDisplayed();
    }
    public void clickOnGallery(){
        elementActions.click(gallery, ElementActions.Locators.accessibilityId);
    }
    public void clickOnGalleryPhotos(){
        elementActions.click(galleryPhotos, ElementActions.Locators.accessibilityId);
    }
    public String getDomAttributeOfGalleryPhoto(){
        WebElement element= elementActions.getWebElement(galleryFirstPhotos, ElementActions.Locators.xpath);
        return element.getDomAttribute("focusable");
    }
    public void swipePhotos(String direction){
        WebElement element= elementActions.getWebElement(galleryFirstPhotos, ElementActions.Locators.xpath);
        elementActions.swipeAction(element,direction);
    }
    public void scrollToWebView(){
        WebElement element= elementActions.getWebElement(webView, ElementActions.Locators.androidUIAutomator);
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
        elementActions.scrollToEndAction();
    }




}
