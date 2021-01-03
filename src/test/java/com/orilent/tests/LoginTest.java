package com.orilent.tests;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orilent.base.BaseClass;
import com.orilent.pages.HomePage;
import com.orilent.pages.LoginPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginTest extends BaseClass{
	AppiumDriver<MobileElement> driver;
	
	@BeforeClass
	public void setup() throws MalformedURLException
	{
		driver=getDriver();
	}
	
	@Test
	public void loginTest() throws InterruptedException
	{
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLoginLink();
		Thread.sleep(6000);
		LoginPage loginPage=new LoginPage(driver);
		loginPage.sendKeysOnEmailField("hello");
	}
}
