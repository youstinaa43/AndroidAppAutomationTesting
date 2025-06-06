package appium;

import actions.ElementActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.PreferencePage;

import java.net.MalformedURLException;
public class TC_001_VerifyPreferenceDependencies extends BaseTest {
    @Epic("Mobile App Testing")
    @Feature("Preference Feature")
    @Test
    public void appiumTest() throws MalformedURLException {
       PreferencePage preferencePage= homePage.clickOnPreference();
       preferencePage.clickOnDependencies();
       preferencePage.clickOnDepenWifiCheckbox();
       preferencePage.clickOnDepenWifiSettings();
        String text=preferencePage.getDepenWifiSettingtitle();
        Assert.assertEquals(text,"WiFi settings");
        preferencePage.sendTextToWifiSetting("Yos");
        preferencePage.clickOnWifiSettingOK();
    }
}
