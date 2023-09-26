package com.opencartAutomation;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCustomer extends Utilitis{
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
	public void deleteExistingCustomer() throws InterruptedException {
		pClass.deleteCustomer();
		assertEquals(deleteCustomerTitle, driver.getTitle());
		pClass.ExistingCustomerID(customerId);
		pClass.accountSubmit();
		Alert alert=driver.switchTo().alert();
		String alertMsg=alert.getText();
		System.out.println(alertMsg);
		Thread.sleep(3000);
		alert.accept();
		
	}
	@Test(dependsOnMethods = {"deleteExistingCustomer"})
	public void logout() {
		pClass.logout();
	}
	@AfterTest
	public void closeBrowser() {
//		driver.quit();
	}
}
