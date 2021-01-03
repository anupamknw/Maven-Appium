package com.selendroid.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegisterPage {
	@AndroidFindBy(id = "inputUsername")
	MobileElement username;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='io.selendroid.testapp:id/inputEmail']")
	MobileElement email;

	public RegisterPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void enterUserName(String un) {
		username.sendKeys(un);
	}

	public void enterEmail(String em) {
		email.sendKeys(em);
	}
}
