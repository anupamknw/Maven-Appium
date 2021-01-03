package com.selendroid.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	@AndroidFindBy(accessibility="startUserRegistrationCD")
	public MobileElement registerBtn; 
	
	public HomePage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickOnRegisterBtn()
	{
		registerBtn.click();
	}
	
}
