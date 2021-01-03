package com.contactsapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class MutliTouchActionDemo {
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "anupam");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");
		AndroidDriver<MobileElement> driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("io.selendroid.testapp:id/touchTest")).click();
		Thread.sleep(5000);
		MobileElement ele=driver.findElement(By.id("LinearLayout1"));

		TouchAction touchAction1=new TouchAction(driver);
		touchAction1.tap(TapOptions.tapOptions().withElement(ElementOption.element(ele)));

		TouchAction touchAction2=new TouchAction(driver);
		touchAction2.tap(PointOption.point(488, 803));

		MultiTouchAction multiTouchAction=new MultiTouchAction(driver);
		multiTouchAction.add(touchAction1).add(touchAction2).perform();

		Thread.sleep(5000);


	}
}
