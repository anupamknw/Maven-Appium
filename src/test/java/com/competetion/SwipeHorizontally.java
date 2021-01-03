package com.competetion;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeHorizontally {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = null;
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "Moto G");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.deskclock");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.deskclock.DeskClock");
        cap.setCapability(AndroidMobileCapabilityType.AVD, "Nexus_5X_API_25");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        horizontalSwipeByPercentage(driver, 0.8, 0.2);
    }

    public static void horizontalSwipeByPercentage(AppiumDriver driver, double startPercentage, double endPercentage) {
        Dimension size = driver.manage().window().getSize();
        int y = (int) (size.height) / 5;
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);

        TouchAction touchAction = new TouchAction(driver);


        touchAction.press(PointOption.point(startPoint, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint, y))
                .release().perform();

        touchAction.press(PointOption.point(startPoint, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint, y))
                .release().perform();
    }
}
