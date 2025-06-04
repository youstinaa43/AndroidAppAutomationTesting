package appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Map;

public class MiscellaneousActions extends BaseTest  {
    @Test
    public void miscellaneousActions() throws MalformedURLException, InterruptedException {
        //adb shell dumpsys window | find "mCurrentFocus"

        ((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of(
                "intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies",
                "waitForLaunch", true
        ));

        //driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        //driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]\n")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        DeviceRotation landScape=new DeviceRotation(0,0,90);
        driver.rotate(landScape);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]\n")).click();
        String text=driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        driver.setClipboardText("Yos WIFI");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElement(AppiumBy.id("android:id/button1")).click();
        Assert.assertEquals(text,"WiFi settings");
        DeviceRotation portiere=new DeviceRotation(0,0,90);
        driver.rotate(portiere);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}
