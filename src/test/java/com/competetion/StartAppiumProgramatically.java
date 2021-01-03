package com.competetion;

import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.GsmCallActions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class StartAppiumProgramatically {
	public static void main(String[] args) throws InterruptedException {
		AppiumDriverLocalService service = null;
		try {
			AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder().usingPort(1234).withIPAddress("127.0.0.1").withLogFile(new File("./logs.txt"));
			service = AppiumDriverLocalService.buildService(serviceBuilder);
			service.start();


			System.out.println("--" + service.isRunning());

			System.out.println(service.getUrl());

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", "Hello");
			caps.setCapability("platformName", "Android");
			caps.setCapability("appPackage", "com.example.android.apis");
			caps.setCapability("appActivity", ".ApiDemos");
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
			AndroidDriver<MobileElement> driver = new AndroidDriver<>(service.getUrl(), caps);
			driver.sendSMS("864832", "Hello");
			driver.makeGsmCall("321733",GsmCallActions.CALL);
			Thread.sleep(2000);
			driver.makeGsmCall("321733",GsmCallActions.ACCEPT);
			driver.quit();
		} finally {
			service.stop();

			System.out.println(service.isRunning());
		}
	}
}
