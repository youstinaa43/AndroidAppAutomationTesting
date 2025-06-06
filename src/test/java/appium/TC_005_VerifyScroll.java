package appium;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.ViewsPage;

public class TC_005_VerifyScroll extends BaseTest{

    @Test
    public void scrollTest(){
        ViewsPage viewsPage=homePage.clickOnViews();
        viewsPage.scrollToWebView();
    }
}
