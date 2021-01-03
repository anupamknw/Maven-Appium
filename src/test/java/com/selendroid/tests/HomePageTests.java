package com.selendroid.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orilent.base.BaseClass;
import com.selendroid.pages.HomePage;
import com.selendroid.pages.RegisterPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePageTests extends BaseClass {
	AppiumDriver<MobileElement> driver = null;

	@BeforeClass
	public void setUp() {
		driver = getDriverForSelendroid();
	}

	@Test
	public void testRegisterBtn() {
		HomePage homePage = new HomePage(driver);
		homePage.clickOnRegisterBtn();
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterEmail("appium@gmail.com");
		registerPage.enterUserName("hello");
	}
}
