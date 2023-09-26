package com.opencartAutomation;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends Utilitis{
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		pClass=new PageObjectClass(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void launchBrowser() {
		driver.get(url);
	}
	@Test
	public void login(){
		pClass.setUid(userID);
		pClass.setPassword(password);
		pClass.Login();
	}
	@Test(dependsOnMethods = {"login"})
	public void verifyLogin() {
		assertEquals(homePageTitle,driver.getTitle());
	}
	@Test(dependsOnMethods = {"verifyLogin"})
	public void logout() {
		pClass.logout();
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}
