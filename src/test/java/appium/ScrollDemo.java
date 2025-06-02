package appium;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollDemo extends BasicTests{

    @Test
    public void scrollTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
         scrollToEndAction();

    }
}
