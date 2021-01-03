package com.contactsapp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ConnectionsDemo_SC {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(AndroidMobileCapabilityType.AVD, "Nexus_6_API_26"); 
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.google.android.apps.photos");
        capabilities.setCapability("appActivity", ".home.HomeActivity");
        
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
        
        System.out.println(driver.getConnection().isWiFiEnabled());
        System.out.println(driver.getConnection().isDataEnabled());
        System.out.println(driver.getConnection().isAirplaneModeEnabled());
        driver.setConnection(new ConnectionState(ConnectionState.DATA_MASK));
        System.out.println(driver.getConnection().isWiFiEnabled());
        System.out.println(driver.getConnection().isDataEnabled());
        System.out.println(driver.getConnection().isAirplaneModeEnabled());
        driver.hideKeyboard();
	}
}
