package actions;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;

public class DeviceActions {
    private AndroidDriver driver;

    public DeviceActions(AndroidDriver driver) {
        this.driver = driver;
    }

    public void rotateToLandScape() {
        DeviceRotation landScape = new DeviceRotation(0, 0, 90);
        driver.rotate(landScape);
    }

    public void rotateToPortiere() {
        DeviceRotation portiere = new DeviceRotation(0, 0, 90);
        driver.rotate(portiere);
    }

    public void setTextToClipboard(String text) {
        driver.setClipboardText(text);
    }

    public String getTextFromClipboard() {
        return driver.getClipboardText();
    }

    public void pressKey(AndroidKey key) {
        driver.pressKey(new KeyEvent(key));
    }
}
