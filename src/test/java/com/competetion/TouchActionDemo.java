package com.competetion;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class TouchActionDemo {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("app", "/Users/in-anupamp/Downloads/selendroid-test-app.apk");
		//caps.setCapability("appPackage", "io.selendroid.testapp");
		//caps.setCapability("appActivity", ".HomeScreenActivity");
		caps.setCapability(AndroidMobileCapabilityType.AVD, "Nexus_6_API_26");
		caps.setCapability("deviceName", "Emulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.VERSION, "8.0");
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementById("touchTest").click();
		Thread.sleep(2000);
		MobileElement ele=driver.findElement(By.id("LinearLayout1"));
		//SingleTap
		//new TouchAction(driver).tap(TapOptions.tapOptions().withElement(ElementOption.element(ele))).perform(); 
		//SingleTap by coordinates
		//new TouchAction(driver).tap(PointOption.point(ele.getLocation().getX()/2,ele.getLocation().getY()/2)).perform(); 
		
		TouchAction action1=new TouchAction(driver).tap(TapOptions.tapOptions().withElement(ElementOption.element(ele)));
		
		TouchAction action2=new TouchAction(driver).tap(PointOption.point(ele.getLocation().getX()/2,ele.getLocation().getY()/2));
		
		new MultiTouchAction(driver).add(action1).add(action2).perform();
		

	}
}
