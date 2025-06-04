package pages;

import actions.ElementActions;
import io.appium.java_client.android.AndroidDriver;

public class PreferencePage {
    AndroidDriver driver;
    ElementActions elementActions;
    String prefXML="1. Preferences from XML";
    String launching="2. Launching preferences";
    String dependencies="3. Preference dependencies";
    String defaultValue="4. Default values";
    String prefCode="5. Preferences from code";
    String advanced="6. Advanced preferences";
    String fragment="7. Fragment";
    String headers="8. Headers";
    String switchPref="9. Switch";
    String depen_WifiCheckbox="android:id/checkbox";
    String depen_WifiSetting="//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout";
    String depen_WifiSetting_Text="android:id/edit";
    String depen_WifiSetting_Ok="android:id/button1";
    String depen_WifiSetting_Cancel="android:id/button2";
    String depen_WifiSetting_title="android:id/alertTitle";
    public PreferencePage(AndroidDriver driver){
        this.driver=driver;
        elementActions=new ElementActions(driver);
    }
    public void clickOnDependencies(){
        elementActions.click(dependencies, ElementActions.Locators.accessibilityId);
    }
    public void clickOnDepenWifiCheckbox(){
        if(!elementActions.isCheckboxChecked(depen_WifiCheckbox, ElementActions.Locators.id)){
            elementActions.click(depen_WifiCheckbox, ElementActions.Locators.id);
        }
    }
    public void clickOnDepenWifiSettings(){
        elementActions.click(depen_WifiSetting, ElementActions.Locators.xpath);
    }
    public void sendTextToWifiSetting(String message){
        elementActions.sendKeys(depen_WifiSetting_Text, ElementActions.Locators.id,message);
        elementActions.click(depen_WifiSetting_Ok, ElementActions.Locators.id);
    }
    public String getDepenWifiSettingtitle(){
        return elementActions.getElementText(depen_WifiSetting_title, ElementActions.Locators.id);
    }


}
