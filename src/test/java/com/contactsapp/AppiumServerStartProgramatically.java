package com.contactsapp;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServerStartProgramatically {
	public static void main(String[] args) {

		AppiumServiceBuilder service=new AppiumServiceBuilder();
		service.usingPort(1234).withIPAddress("127.0.0.1").withLogFile(new File("/Users/in-anupamp/Downloads/logs.txt")).build();
		AppiumDriverLocalService server=AppiumDriverLocalService.buildService(service);
		server.start();

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "anupam");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(AndroidMobileCapabilityType.AVD, "Nexus_5X_API_25");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "/Users/in-anupamp/Downloads/chromedriver2");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(server.getUrl(),
				cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		server.stop();
	}
}
