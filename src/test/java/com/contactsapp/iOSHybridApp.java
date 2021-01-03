package com.contactsapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class iOSHybridApp {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.2");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		caps.setCapability(MobileCapabilityType.APP, "/Users/in-anupamp/Documents/workspace/Maven-Appium/vodqa.zip");
		IOSDriver<MobileElement> driver=new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AccessibilityId("login")).click();
		driver.findElement(MobileBy.name("webView")).click();
		Thread.sleep(20000);
		System.out.println(driver.getContextHandles());
		
		Set<String> contexts=driver.getContextHandles();
		
		for (String context : contexts) {
			if(context.contains("WEBVIEW"))
			{
				driver.context(context);
			}
		}
		
		List<MobileElement> li=driver.findElements(By.xpath("//td[@class='title']/a"));
		
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i).getText());
		}
	}
}
