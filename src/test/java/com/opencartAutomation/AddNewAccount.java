package com.opencartAutomation;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddNewAccount extends Utilitis{
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
	public void addNewAccount() throws InterruptedException {
		WebElement newAccount=driver.findElement(By.xpath("//a[contains(text(),'New Account')]"));
		newAccount.click();
		assertEquals(addNewAccountTitle, driver.getTitle());
		pClass.ExistingCustomerID(customerId);
		Select select=new Select(driver.findElement(By.name("selaccount")));
		select.selectByIndex(1);
		driver.findElement(By.name("inideposit")).sendKeys("20000");
		pClass.addNewAccount();
		Thread.sleep(2000);
		assertEquals(successRegistration, driver.getTitle());
		Thread.sleep(2000);
		
		 WebElement accountNO=driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[2]"));
		 String accountNumber=accountNO.getText();
		 System.out.println(accountNumber);
	}
	@Test(dependsOnMethods = {"addNewAccount"})
	public void logout() {
		pClass.logout();
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
