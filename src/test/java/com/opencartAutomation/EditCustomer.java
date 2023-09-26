package com.opencartAutomation;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditCustomer extends Utilitis{
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
	@Test (dependsOnMethods = {"login"})
	public void editCustomer() throws InterruptedException {
		pClass.editCustomer();
		assertEquals(editCustomerTitle, driver.getTitle());
		pClass.ExistingCustomerID(customerId);
		Thread.sleep(2000);
		pClass.accountSubmit();
		assertEquals(editCustomerEntryTitle, driver.getTitle());
		Thread.sleep(3000);
		pClass.setPin(newPin);
		Thread.sleep(1000);
		pClass.submit();
	}
	@Test(dependsOnMethods = {"editCustomer"})
	public void logout() {
		pClass.logout();
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
