package com.competetion;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestOneSelendroid {

	@Test
	public void test() throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("app", "/Users/in-anupamp/Downloads/selendroid-test-app.apk");
		//caps.setCapability("appPackage", "io.selendroid.testapp");
		//caps.setCapability("appActivity", ".HomeScreenActivity");
		caps.setCapability("deviceName", "Emulator");
		caps.setCapability(AndroidMobileCapabilityType.AVD, "Nexus_6_API_26");
		caps.setCapability("platformName", "Android");
		caps.setCapability(MobileCapabilityType.VERSION, "8.0");
		AppiumDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@text='EN Button']")).click();
		String s=driver.findElement(By.xpath("//android.widget.TextView")).getText();
		System.out.println(s);
		//driver.findElement(By.xpath("//android.widget.Button[@text='I agree']")).click(); - It will end activity
		driver.findElement(By.xpath("(//android.widget.Button)[2]")).click();
		driver.findElement(By.id("startUserRegistration")).click();
		
		//Register User
		driver.findElement(By.id("inputUsername")).sendKeys("Hello");
		driver.findElement(By.id("inputEmail")).sendKeys("hello@gmail.com");
		driver.findElement(By.id("inputPassword")).sendKeys("12345");
		System.out.println(driver.findElement(By.id("inputName")).getText());
		driver.navigate().back(); // Navigate back
		driver.findElement(By.id("input_preferedProgrammingLanguage")).click();
		driver.findElement(By.xpath("//*[@text='C++']")).click();
		driver.findElement(By.id("input_adds")).click();
		driver.findElement(By.id("btnRegisterUser")).click();
		driver.findElement(By.id("buttonRegisterUser")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.id("buttonRegisterUser")).click();
		System.out.println(driver.getContext());
		//System.out.println("current url: "+driver.getCurrentUrl());
		System.out.println("pagesource: "+driver.getPageSource());
		//System.out.println("title: "+driver.getTitle());
		System.out.println("isBrowser: "+driver.isBrowser());
		//System.out.println("BatteryInfo: "+driver.getBatteryInfo());
		System.out.println("Contexthandles: "+driver.getContextHandles());
		System.out.println("Orientation: "+driver.getOrientation());
		System.out.println("RemoteAddress: "+driver.getRemoteAddress());
		System.out.println("Session ID: "+driver.getSessionId());
		//System.out.println("Location: "+driver.location());
		//System.out.println("Rotation: "+driver.rotation());
		driver.rotate(ScreenOrientation.LANDSCAPE);
		driver.rotate(ScreenOrientation.PORTRAIT);
		Thread.sleep(3000l);
		driver.quit();
	}

}
