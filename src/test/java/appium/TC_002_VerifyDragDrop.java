package appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.ViewsPage;

public class TC_002_VerifyDragDrop extends BaseTest{
    @Test
    public void dragDropTest(){
        ViewsPage viewsPage=homePage.clickOnViews();
        viewsPage.clickOnDragDrop();
        viewsPage.dragAndDrop();
        String result=viewsPage.getDroppedText();
        Assert.assertEquals(result,"Dropped!");
    }
}
