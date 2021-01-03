package com.competetion;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Tourisz_Swipe {
	
	public static void main(String[] args) throws InterruptedException {
		AndroidDriver<MobileElement> driver = null;
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
			cap.setCapability(MobileCapabilityType.APP, "/Users/in-anupamp/Downloads/Tourisz.apk");
//			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.tourisz");
//			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
//					"com.tourisz.user.view.activity.SplashActivity");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
			cap.setCapability(AndroidMobileCapabilityType.AVD, "Nexus_5X_API_25");
			driver = new AndroidDriver<MobileElement>(service.getUrl(), cap);

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			Thread.sleep(6000);
			driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("edtUname")).click();
			driver.findElement(By.id("edtUname")).sendKeys("appium1@gmail.com");
			driver.findElement(By.id("edtPassword")).sendKeys("123456");
			driver.hideKeyboard();
			driver.findElement(By.id("btnLogin")).click();
			driver.findElement(By.className("android.widget.ImageButton")).click();
			Thread.sleep(2000);
			verticalSwipeByPercentages(driver, 0.8, 0.2);
			driver.findElement(By.id("com.tourisz:id/txtNavLogout")).click();
		}finally {
			service.stop();
		}
	}
	
    public static void verticalSwipeByPercentages(AppiumDriver driver,double startPercentage, double endPercentage) {
        Dimension size = driver.manage().window().getSize();
        int x = (int) (size.width)/2;
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
 
        new TouchAction(driver)
                .press(PointOption.point(x, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(x, endPoint))
                .release().perform();
    }

}
