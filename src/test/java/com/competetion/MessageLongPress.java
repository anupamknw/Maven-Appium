package com.competetion;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.Setting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class MessageLongPress {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(AndroidMobileCapabilityType.AVD, "Nexus_6_API_26");
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "Nexus 9");
		cap.setCapability("appPackage", "com.google.android.apps.messaging");
		cap.setCapability("appActivity", "com.google.android.apps.messaging.ui.conversationlist.ConversationListActivity");
		AndroidDriver<MobileElement>driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		TouchAction touchAction=new TouchAction(driver);
		touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(driver.findElement(By.id("action_search"))))).perform();
		System.out.println(driver.currentActivity());
		driver.startActivity(new Activity("com.android.settings", "com.android.settings.Settings"));
		Map<String, Object> settings = driver.getSettings();

		Set<String> st=settings.keySet();

		Iterator<String> itr=st.iterator();

		while(itr.hasNext())
		{
			String key=itr.next();
			System.out.println(key+" "+settings.get(key));
		}

		driver.lockDevice();
		Thread.sleep(1000);
		driver.unlockDevice();
		System.out.println(driver.getConnection().isAirplaneModeEnabled());
		System.out.println(driver.getConnection().isDataEnabled());
		System.out.println(driver.getConnection().isWiFiEnabled());
		System.out.println(driver.getDeviceTime());

	}
}
