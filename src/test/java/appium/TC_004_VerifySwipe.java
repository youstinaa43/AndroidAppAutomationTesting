package appium;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.ViewsPage;

public class TC_004_VerifySwipe extends BaseTest{
    @Test
    public void  swipeTest(){
        ViewsPage viewsPage=homePage.clickOnViews();
        viewsPage.clickOnGallery();
        viewsPage.clickOnGalleryPhotos();
        Assert.assertEquals(viewsPage.getDomAttributeOfGalleryPhoto(),"true");
        viewsPage.swipePhotos("left");
        Assert.assertEquals(viewsPage.getDomAttributeOfGalleryPhoto(),"false");
    }
}
