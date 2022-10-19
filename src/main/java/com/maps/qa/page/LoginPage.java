package com.maps.qa.page;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.maps.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	//page factory
	@FindBy(id="email")
	WebElement username;
	
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-btn")
	WebElement loginbtn;
	
	@FindBy(xpath="//img [@class='img-fluid']")
	WebElement MapsappLogo;
	// Initilizing pageobject
	public LoginPage() {
		PageFactory.initElements(driver,this);
		
		// Action
	}
	public String validateloginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateMapappsLogo() {
		return MapsappLogo.isDisplayed();
	}
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();

		return new HomePage ();
		
	}

}


