package com.contactsapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeVerticallyDemo_SC {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "anupam");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.android.apis");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
		AndroidDriver<MobileElement> driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();

		verticalSwipeByPercentages(driver, 0.8, 0.2);
		Thread.sleep(2000);

		verticalSwipeByPercentages(driver, 0.8, 0.2);
		Thread.sleep(2000);

		verticalSwipeByPercentages(driver, 0.2, 0.8);
		Thread.sleep(2000);

		verticalSwipeByPercentages(driver, 0.2, 0.8);
		Thread.sleep(2000);


//		while(true)
//		{
//			verticalSwipeByPercentages(driver, 0.8, 0.2);
//			Thread.sleep(2000);
//			if(driver.findElements(By.xpath("//android.widget.TextView[@text='Rotating Button']")).size()>0)
//			{
//				break;
//			}
//		}
//
//		driver.findElement(By.xpath("//android.widget.TextView[@text='Rotating Button']")).click();
	}
	
    public static void verticalSwipeByPercentages(AppiumDriver driver,double startPercentage, double endPercentage) {
        Dimension size = driver.manage().window().getSize();
        int x = (int) (size.width)/2;
        int y_startPoint = (int) (size.height * startPercentage);
        int y_endPoint = (int) (size.height * endPercentage);
 
        TouchAction touchAction=new TouchAction(driver);
                touchAction.press(PointOption.point(x, y_startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(x, y_endPoint))
                .release().perform();
    }

}
