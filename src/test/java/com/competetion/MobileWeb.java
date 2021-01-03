package com.competetion;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class MobileWeb {
	private static By EMAIL = By.id("contactEmail");
	private static By MESSAGE = By.id("contactText");
	private static By SEND = By.cssSelector("input[type=submit]");
	private static By ERROR = By.cssSelector(".contactResponse");

	@Test
	public void testAppiumProSite_Android() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("browserName", "Browser");

		// Open up Safari
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
		actualTest(driver);
	}

    @Test
    public void testAppiumProSite_iOS() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "11.2");
        capabilities.setCapability("deviceName", "iPhone 7");
        capabilities.setCapability("browserName", "Safari");

        // Open up Safari
        IOSDriver<MobileElement> driver = new IOSDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
        actualTest(driver);
    }


	public void actualTest(AppiumDriver<MobileElement> driver) {
		// Set up default wait
		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			driver.get("http://appiumpro.com/contact");
			wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL)).sendKeys("foo@foo.com");
			driver.findElement(MESSAGE).sendKeys("Hello!");
			driver.findElement(SEND).click();
			String response = wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR)).getText();

			// validate that we get an error message involving a captcha, which we didn't
			// fill out
			System.out.println(response);
		} finally {
			driver.quit();
		}

	}
}
