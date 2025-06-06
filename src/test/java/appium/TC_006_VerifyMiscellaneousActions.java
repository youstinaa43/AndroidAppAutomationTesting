package appium;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.PreferencePage;

import java.net.MalformedURLException;

public class TC_006_VerifyMiscellaneousActions extends BaseTest  {
    @Test
    public void miscellaneousActions() throws MalformedURLException, InterruptedException {
        PreferencePage preferencePage=homePage.clickOnPreference();
        preferencePage.clickOnDependencies();
        preferencePage.clickOnDepenWifiCheckbox();
        deviceActions.rotateToLandScape();
        preferencePage.clickOnDepenWifiSettings();
        String text=preferencePage.getDepenWifiSettingtitle();
        Assert.assertEquals(text,"WiFi settings");
        preferencePage.sendTextToWifiSetting("Yos WIFI");
        deviceActions.pressKey(AndroidKey.ENTER);
        preferencePage.clickOnWifiSettingOK();
        deviceActions.rotateToPortiere();
        deviceActions.pressKey(AndroidKey.BACK);
        deviceActions.pressKey(AndroidKey.HOME);
    }
}
