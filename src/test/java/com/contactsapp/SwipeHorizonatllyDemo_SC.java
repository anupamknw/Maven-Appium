package com.contactsapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.touch.TapOptions;
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

public class SwipeHorizonatllyDemo_SC {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "anupam");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.dialer");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.dialer.DialtactsActivity");
		AndroidDriver<MobileElement> driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		horizontalSwipeByPercentage(driver, 0.9, 0.1);
		Thread.sleep(2000);
		horizontalSwipeByPercentage(driver, 0.9, 0.1);
		Thread.sleep(2000);
		horizontalSwipeByPercentage(driver, 0.1, 0.9);
		Thread.sleep(2000);
		horizontalSwipeByPercentage(driver, 0.1, 0.9);

	}

	public static void horizontalSwipeByPercentage(AppiumDriver<MobileElement> driver,double startPercentage, double endPercentage) {
        Dimension size = driver.manage().window().getSize();

        int y = (int) (size.height )/2;
        int x_startPoint = (int) (size.width * startPercentage);
        int x_endPoint = (int) (size.width * endPercentage);

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(x_startPoint, y))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(x_endPoint, y))
                .release().perform();
    }
}
