package com.competetion;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

// adb shell ls /mnt/sdcard
public class RunADBCommands {

	private static String ANDROID_PHOTO_PATH = "/mnt/sdcard/Pictures";

	@Test
	public void testArbitraryADBCommands() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("appPackage", "com.google.android.apps.photos");
		capabilities.setCapability("appActivity", ".home.HomeActivity");
		// Open the app.
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),
				capabilities);

		try {
			List<String> lsArgs = Arrays.asList("/mnt/sdcard");
			Map<String, Object> lsCmd = ImmutableMap.of("command", "ls", "args", lsArgs);
			String lsOutput = (String) driver.executeScript("mobile: shell", lsCmd);
			System.out.println(lsOutput);
		} finally {
			driver.quit();
		}
	}

}
