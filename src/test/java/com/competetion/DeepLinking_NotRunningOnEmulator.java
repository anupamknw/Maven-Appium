package com.competetion;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import java.io.IOException;
import java.net.URL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeepLinking_NotRunningOnEmulator {

    private String APP_ANDROID = "https://github.com/cloudgrey-io/the-app/releases/download/v1.2.1/TheApp-v1.2.1.apk";

    private String AUTH_USER = "alice";
    private String AUTH_PASS = "mypassword";


    @Test
    public void testLoginSlowAndroid() throws IOException {
        AndroidModel model = new AndroidModel();
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), model.caps);
        runStepByStepTest(driver, model);
    }

    private void runStepByStepTest(AppiumDriver driver, Model model) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(model.loginScreen)).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(model.username)).sendKeys(AUTH_USER);
            wait.until(ExpectedConditions.presenceOfElementLocated(model.password)).sendKeys(AUTH_PASS);
            wait.until(ExpectedConditions.presenceOfElementLocated(model.loginBtn)).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(model.getLoggedInBy(AUTH_USER)));
        } finally {
            driver.quit();
        }
    }


    @Test
    public void testDeepLinkForDirectNavAndroid () throws IOException {
        AndroidModel model = new AndroidModel();
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), model.caps);
        runDeepLinkTest(driver, model);
    }

    private void runDeepLinkTest(AppiumDriver driver, Model model) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            driver.get("theapp://login/" + AUTH_USER + "/" + AUTH_PASS);
            wait.until(ExpectedConditions.presenceOfElementLocated(model.getLoggedInBy(AUTH_USER)));
        } finally {
            driver.quit();
        }
    }

    private abstract class Model {
        public By loginScreen = MobileBy.AccessibilityId("Login Screen");
        public By loginBtn = MobileBy.AccessibilityId("loginBtn");
        public By username;
        public By password;

        public DesiredCapabilities caps;

        abstract By getLoggedInBy(String username);
    }


    private class AndroidModel extends Model {
        AndroidModel() {
            username = MobileBy.AccessibilityId("username");
            password = MobileBy.AccessibilityId("password");

            caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("deviceName", "Android Emulator");
            caps.setCapability("app", APP_ANDROID);
            caps.setCapability("automationName", "UiAutomator2");
        }

        public By getLoggedInBy(String username) {
            return By.xpath("//android.widget.TextView[@text=\"You are logged in as " + username + "\"]");
        }
    }
}