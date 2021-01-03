package com.contactsapp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class iOSLaunchBrowser {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		IOSDriver<MobileElement> driver=new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		driver.get("http://www.google.com");

	}
}
