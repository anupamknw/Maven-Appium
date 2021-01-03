package com.contactsapp;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

// Note that to function correctly, this test must be run against a version of Appium which includes
// the appium-android-driver package at version 1.38 or higher, since it contains relevant bugfixes

public class FilePushDemo {

   // private static String ANDROID_PHOTO_PATH = "/mnt/sdcard/Pictures";
	private static String ANDROID_PHOTO_PATH = "/storage/emulated/0/Pictures";
    private static By backupSwitch = By.id("com.google.android.apps.photos:id/auto_backup_switch");
    private static By touchOutside = By.id("com.google.android.apps.photos:id/touch_outside");
    private static By keepOff = By.xpath("//*[@text='KEEP OFF']");
    private static By photo = By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Photo taken')]");
    private static By trash = By.id("com.google.android.apps.photos:id/trash");
    private static By moveToTrash = By.xpath("//*[@text='MOVE TO TRASH']");

    @Test
    public void testSeedPhotoPicker() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        File classpathRoot = new File(System.getProperty("user.dir"));
		capabilities.setCapability(AndroidMobileCapabilityType.AVD, "Nexus_5X_API_25");

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.google.android.apps.photos");
        capabilities.setCapability("appActivity", ".home.HomeActivity");

        // Open the app.
        AndroidDriver driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);

        try {
            // there's some screens we need to navigate through and ensure there are no existing photos
            //setupAppState(driver);

            // set up the file we want to push to the phone's library
            File img = new File("/Users/in-anupamp/Downloads/example.png");

            // actually push the file
            driver.pushFile(ANDROID_PHOTO_PATH + "/" + img.getName(), img);
            
            // wait for the system to acknowledge the new photo, and use the WebDriverWait to verify
            // that the new photo is there

            Thread.sleep(5000);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            ExpectedCondition condition = ExpectedConditions.numberOfElementsToBe(photo,1);
            wait.until(condition);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public void setupAppState(AndroidDriver driver) {
        // navigate through the google junk to get to the app
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebDriverWait shortWait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.presenceOfElementLocated(backupSwitch)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(touchOutside)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(keepOff)).click();

        // delete any existing pictures using an infinite loop broken when we can't find any
        // more pictures
        try {
            while (true) {
                shortWait.until(ExpectedConditions.presenceOfElementLocated(photo)).click();
                shortWait.until(ExpectedConditions.presenceOfElementLocated(trash)).click();
                shortWait.until(ExpectedConditions.presenceOfElementLocated(moveToTrash)).click();
            }
        } catch (TimeoutException ignore) {}
    }
}