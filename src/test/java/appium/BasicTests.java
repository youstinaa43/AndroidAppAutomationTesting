package appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BasicTests {
    AndroidDriver driver;
    AppiumDriverLocalService service;
    @BeforeClass
    public void configureAppium() throws MalformedURLException {
        // Setup Appium Service
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\EL-BOSTAN\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(() -> "--relaxed-security")
                .build();
        service.start();

        // Setup Device Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("CPH1911");
        options.setUdid("LZZDJVKBROJVS4FE");
        options.setPlatformVersion("11");
        options.setApp("F:\\Java\\Projects\\Mobile_Testing_FrameWork\\src\\test\\java\\resource\\ApiDemos-debug.apk");

        // General Capabilities
        options.setAutomationName("UiAutomator2");
        options.setNoReset(true); // Start with false to install fresh
        options.setFullReset(false);
        options.setAutoGrantPermissions(true);
        options.setCapability("skipUnlock", true);
        options.setCapability("ignoreHiddenApiPolicyError", true);
        options.setCapability("disableWindowAnimation", true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }
    public void longPressAction(WebElement element){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
                        "duration",2000));
    }
    public void scrollToEndAction(){
        boolean canScrollMore;
        do{
            canScrollMore=(Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of(
                            "left",100, "top",100, "width",200,"height",200,
                            "direction","down","percent",3.0
                    ));
        }while (canScrollMore);
    }
    public void swipeAction(WebElement element,String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of(
                        "elementId",((RemoteWebElement)element).getId(),
                        "direction",direction,"percent",0.75
                ));
    }
    public void dragDropAction(WebElement element){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
                ImmutableMap.of(
                        "elementId",((RemoteWebElement)element).getId(),
                        "endX",665,"endY",585
                ));
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
