package com.opencartAutomation;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddNewCustomer extends Utilitis{
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
	public void addNewCustomerWithAllCredentials() throws InterruptedException {
		pClass.addNewCustomer();
		assertEquals(newCustomerTitle, driver.getTitle());
		pClass.setName(Name);
		pClass.checkMaleGender();
		pClass.setdateOfBirth();
		Thread.sleep(5000);
		pClass.setAddress(address);
		pClass.setAddress(address);
		pClass.setCity(city);
		pClass.setState(state);
		pClass.setPin(pin);
		pClass.setPhoneNumber(mobileNumber);
		String Email=setRandomEmail()+"@gmail.com";
		pClass.setEmail(Email);
		pClass.setPassword(password);
		pClass.submit();
		
		assertEquals(customerRegistrationPage, driver.getTitle());
	}
	@Test(dependsOnMethods = {"addNewCustomerWithAllCredentials"})
	public void logout() {
		pClass.logout();
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
