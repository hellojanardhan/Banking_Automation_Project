package com.opencartAutomation;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteAccount extends Utilitis{
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
	@Test(dependsOnMethods = {"launchBrowser"})
	public void login(){
		pClass.setUid(userID);
		pClass.setPassword(password);
		pClass.Login();
		assertEquals(homePageTitle, driver.getTitle());
	}
	@Test(dependsOnMethods = {"login"})
	public void deleteAccount() {
		pClass.deleteAccount();
		assertEquals(deleteAccountPageTitle, driver.getTitle());
		pClass.deleteAccNumber(accountNumber);
		pClass.accountSubmit();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	@Test(dependsOnMethods = {"deleteAccount"})
	public void logout() {
		pClass.logout();
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
