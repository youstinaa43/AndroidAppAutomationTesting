package appium;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.ViewsPage;

import java.net.MalformedURLException;

public class TC_003_VerifyLongPress extends BaseTest{
    @Test
    public void longPress() throws MalformedURLException, InterruptedException {
        ViewsPage viewsPage=homePage.clickOnViews();
        viewsPage.clickOnExpandableLists();
        viewsPage.clickOnExpandCustomAdapter();
        viewsPage.longPressOnPeopleNames();
        String menuText=viewsPage.getSampleMenuText();
        Assert.assertEquals(menuText,"Sample menu");
        Assert.assertTrue(viewsPage.isSampleMenuDisplayed());
    }
}
