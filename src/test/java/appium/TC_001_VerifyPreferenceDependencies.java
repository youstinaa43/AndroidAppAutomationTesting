package appium;

import actions.ElementActions;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PreferencePage;

import java.net.MalformedURLException;
public class TC_001_VerifyPreferenceDependencies extends BaseTest {
    @Test
    public void appiumTest() throws MalformedURLException {
       PreferencePage preferencePage= homePage.clickOnPreference();
       preferencePage.clickOnDependencies();
       preferencePage.clickOnDepenWifiCheckbox();
       preferencePage.clickOnDepenWifiSettings();
        String text=preferencePage.getDepenWifiSettingtitle();
        Assert.assertEquals(text,"WiFi settings");
        preferencePage.sendTextToWifiSetting("Yos");
    }
}
