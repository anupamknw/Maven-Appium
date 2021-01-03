package com.competetion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TouriszDemoFutureDateSelection {
	
	public static void main(String[] args) throws InterruptedException {
		AppiumDriver<MobileElement> driver = null;
		AppiumDriverLocalService service = null;
		try {
			AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
			service = AppiumDriverLocalService.buildService(serviceBuilder);
			service.start();

			System.out.println("--" + service.isRunning());
			System.out.println(service.getUrl());

			
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("platformName", "Android");
			cap.setCapability("deviceName", "Moto G");
			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.tourisz");
			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
					"com.tourisz.user.view.activity.SplashActivity");
			cap.setCapability(AndroidMobileCapabilityType.AVD, "Galaxy_Nexus_API_27");
			driver = new AndroidDriver<MobileElement>(service.getUrl(), cap);

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			Thread.sleep(6000);
			driver.findElement(By.id("edtUname")).sendKeys("appium@gmail.com");
			driver.findElement(By.id("edtPassword")).sendKeys("123456");
			driver.hideKeyboard();
			driver.findElement(By.id("btnLogin")).click();

			driver.findElement(By.id("txtHotel")).click();

			driver.findElement(By.xpath("(//android.widget.TextView[@index='2'])[3]")).click();

			driver.findElement(By.id("btnFromDate")).click();

			String fromDate = "19-Mar-2019";

			selectDate(driver, fromDate);

			driver.findElement(By.id("android:id/button1")).click();
		
		} finally {
			Thread.sleep(15000);
			service.stop();
			System.out.println(service.isRunning());
		}
	}

	public static void selectDate(AppiumDriver<MobileElement> driver, String fromDate) {

		String getDay = fromDate.split("-")[0];//19
		String getMonth = fromDate.split("-")[1];//Mar
		String getYear = fromDate.split("-")[2];//2019

		while (true) {
			driver.findElement(By.xpath("//android.view.View[last()]")).click();

			if (driver.findElement(By.id("date_picker_header_year")).getText().equals(getYear)
					&& driver.findElement(By.id("date_picker_header_date")).getText().contains(getMonth)) {
				break;
			}

			driver.findElement(By.id("next")).click();
		}

		driver.findElement(By.xpath("//android.view.View[@text='" + getDay + "']")).click();
	}
}
