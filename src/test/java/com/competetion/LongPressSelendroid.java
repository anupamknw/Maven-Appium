package com.competetion;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class LongPressSelendroid {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setCapability("app", "/Users/in-anupamp/Downloads/selendroid-test-app.apk");
		caps.setCapability("appPackage", "io.selendroid.testapp");
		caps.setCapability("appActivity", ".HomeScreenActivity");
		caps.setCapability("deviceName", "Emulator");

		caps.setCapability(AndroidMobileCapabilityType.AVD, "Nexus_5X_API_25");
		caps.setCapability("platformName", "Android");
		caps.setCapability(MobileCapabilityType.VERSION, "7.1.1");
		AppiumDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		TouchAction touchAction =new TouchAction(driver);
		touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(driver.findElement(By.id("io.selendroid.testapp:id/buttonTest"))))).perform();

	}
}
