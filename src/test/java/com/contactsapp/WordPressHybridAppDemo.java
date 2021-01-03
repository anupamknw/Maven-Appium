package com.contactsapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class WordPressHybridAppDemo {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(AndroidMobileCapabilityType.AVD, "Galaxy_Nexus_API_27"); 
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "UiAutomator2");
       // capabilities.setCapability("appPackage", "org.wordpress.android");
       // capabilities.setCapability("appActivity", ".ui.WPLaunchActivity");
        capabilities.setCapability("app", "/Users/in-anupamp/Downloads/WordPress.apk");
        capabilities.setCapability("fastReset", true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("org.wordpress.android:id/login_button")).click();
       Thread.sleep(2000);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.id("org.wordpress.android:id/input")).sendKeys("vodqa@gmail.com");
        driver.findElement(By.id("org.wordpress.android:id/primary_button")).click();
        Thread.sleep(6000);
        driver.findElement(By.id("org.wordpress.android:id/login_enter_password")).click();
        Thread.sleep(6000);
        driver.findElement(By.id("org.wordpress.android:id/input")).sendKeys("Hello12345678");
        driver.findElement(By.id("org.wordpress.android:id/primary_button")).click();
        Thread.sleep(12000);
        driver.findElement(By.id("org.wordpress.android:id/primary_button")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='Reader. Follow content from other sites.']")).click();
        Thread.sleep(4000);
        driver.findElements(By.id("org.wordpress.android:id/visit")).get(1).click();
        Thread.sleep(8000);
        System.out.println(driver.getContextHandles());
        
        driver.context("WEBVIEW_org.wordpress.android");
        
        Thread.sleep(2000);
        
        List<MobileElement> li=driver.findElements(By.tagName("a"));
        for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i).getText());
		}
        
	}
}
