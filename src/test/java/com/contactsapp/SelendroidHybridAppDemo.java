package com.contactsapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class SelendroidHybridAppDemo {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "anupam");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(AndroidMobileCapabilityType.AVD, "Galaxy_Nexus_API_27");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "/Users/in-anupamp/Downloads/chromedriver2");
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),
				cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(MobileBy.id("io.selendroid.testapp:id/buttonStartWebview")).click();
		Thread.sleep(4000);
		System.out.println(driver.getContextHandles());
		System.out.println(driver.getContext());
		Thread.sleep(4000);

		Set<String> contexts = driver.getContextHandles();

		Iterator<String> itr = contexts.iterator();

		while (itr.hasNext()) {
			String context = itr.next();
			if (context.contains("WEBVIEW")) {
				driver.context(context);
			}
		}

		System.out.println(driver.getContext());
		driver.findElement(By.id("name_input")).clear();
		driver.findElement(By.id("name_input")).sendKeys("Orilent");

	}
}
