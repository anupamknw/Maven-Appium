package com.contactsapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class RunTestInParallel_SC {
	private static AndroidDriver<MobileElement> driver;

	@Test
	public void f() {
	}

	@Parameters(value={ "deviceName_","UDID_", "URL_" })
	@BeforeMethod
	public void beforeMethod(String deviceName_,String UDID_,String URL_) throws MalformedURLException, InterruptedException {
		System.out.println("Hello");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName_);
		capabilities.setCapability("udid", UDID_);
		//capabilities.setCapability("platformVersion", platformVersion_);
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "io.selendroid.testapp");
		capabilities.setCapability("appActivity", ".HomeScreenActivity");
		driver = new AndroidDriver<MobileElement>(new URL("http://"+URL_), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);
	}

	@AfterMethod
	public void afterMethod() {
	}
}
