package com.competetion;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class iOSVodQAHybridAppDemo {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS Simulator");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.2");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(MobileCapabilityType.APP, "/Users/in-anupamp/Documents/workspace/Maven-Appium/vodqa.zip");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		AppiumDriver<MobileElement> driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//XCUIElementTypeOther[@name='login']")).click();
		driver.findElement(MobileBy.name("login")).click();
		driver.findElement(MobileBy.name("webView")).click();
		Thread.sleep(3000);
		System.out.println(driver.getContextHandles());

		Set<String> contexts = driver.getContextHandles();

		Iterator<String> itr = contexts.iterator();

		while (itr.hasNext()) {
			String context = itr.next();
			if (context.contains("WEBVIEW")) {
				driver.context(context);
			}
		}
		
		List<MobileElement> li=driver.findElements(By.tagName("a"));
		
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i).getText());
		}
		

	}
}
