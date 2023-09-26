package com.opencartAutomation;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditAccount extends Utilitis{
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
	public void editAccount() throws InterruptedException {
		pClass.editAccount();
		assertEquals(editAccountTitle, driver.getTitle());
		
		driver.findElement(By.name("accountno")).sendKeys(accountNumber);
		Thread.sleep(1000);
		pClass.accountSubmit();
		Thread.sleep(2000);
	}
	@Test(dependsOnMethods = {"editAccount"})
	public void logout() {
		pClass.logout();
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
