package com.contactsapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class MultipleAppWithSingleSession_SC {
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "anupam");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");
		cap.setCapability(AndroidMobileCapabilityType.AVD, "Nexus_5X_API_25");
		AndroidDriver<MobileElement> driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("io.selendroid.testapp:id/touchTest")).click();
		Thread.sleep(3000);
		String orig_app_activity=driver.currentActivity();
		System.out.println(orig_app_activity);
		String orig_app_package=driver.getCurrentPackage();
		Thread.sleep(5000);
		driver.startActivity(new Activity("com.example.android.apis", ".ApiDemos"));
		System.out.println(orig_app_package);
		Thread.sleep(10000);
		driver.activateApp(orig_app_package);
	}
}
