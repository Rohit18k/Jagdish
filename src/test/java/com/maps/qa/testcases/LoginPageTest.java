package com.maps.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.maps.qa.base.TestBase;
import com.maps.qa.page.HomePage;
import com.maps.qa.page.LoginPage;

public class LoginPageTest extends TestBase  {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		 loginpage = new LoginPage();
	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginpage.validateloginPageTitle();
		Assert.assertEquals(title, "Login Page");
	}
	
	@Test(priority=2)
	public void mapsappLogoTest() {
		boolean Logo = loginpage.validateMapappsLogo();
		Assert.assertTrue(Logo);
	}
	@Test(priority=3)
	public void loginpage() {
		loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
