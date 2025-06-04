package appium;

import actions.ElementActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected static AndroidDriver driver;
    protected static AppiumDriverLocalService service;
    protected static Properties props;
    HomePage homePage;

    @BeforeSuite
    public void beforeSuite() throws Exception {
        props = new Properties();
        InputStream input = new FileInputStream("src/main/resources/config.properties");
        props.load(input);
        service = new AppiumServiceBuilder()
                .withIPAddress(props.getProperty("appiumHost"))   // 127.0.0.1
                .usingPort(Integer.parseInt(props.getProperty("appiumPort"))) // 4723
                .withAppiumJS(new File("C:\\Users\\EL-BOSTAN\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .build();
        service.start();
    }

    @BeforeClass
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(props.getProperty("platformName"));         // Android
        options.setPlatformVersion(props.getProperty("platformVersion"));   // 11
        options.setDeviceName(props.getProperty("deviceName"));             // CPH1911
        options.setUdid(props.getProperty("udid"));                         // LZZDJVKBROJVS4FE
        String appPath = props.getProperty("appPath"); //  drivers/ApiDemos-debug.apk
        options.setApp(System.getProperty("user.dir") + "/" + appPath);
        options.setAutomationName("UiAutomator2");
        options.setNoReset(true);
        options.setFullReset(false);
        options.setSkipUnlock(true);
        options.setAutoGrantPermissions(true);
        options.setIgnoreHiddenApiPolicyError(true);
        options.setDisableWindowAnimation(true);
        URL appiumURL = new URL("http://" + props.getProperty("appiumHost") + ":" + props.getProperty("appiumPort") );
        driver = new AndroidDriver(appiumURL, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage=new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void afterSuite() {
        if (service != null && service.isRunning()) {
            service.stop();
        }
    }
}
