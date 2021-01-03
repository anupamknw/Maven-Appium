package com.contactsapp;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class iOSWordPressApp {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11 Pro Max");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		caps.setCapability(MobileCapabilityType.APP, "/Users/in-anupamp/Documents/workspace/Maven-Appium/WordPress.app");
		//caps.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "org.wordpress");
		IOSDriver<MobileElement> driver=new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		//driver.findElement(By.xpath("//XCUIElementTypeTextField[@value='Email or username']")).sendKeys("hello");

	}
}
