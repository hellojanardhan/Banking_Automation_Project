package com.opencartAutomation;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class Utilitis {
	public WebDriver driver;
	public PageObjectClass pClass;
	public String url="https://www.demo.guru99.com/V4/";
	public String userID="mngr525834";
	public String password="sAzusUp";
	public String homePageTitle="Guru99 Bank Manager HomePage";
	
	//Add new customer
	public String newCustomerTitle="Guru99 Bank New Customer Entry Page";
	public String Name="Alex";
	public String dateOfBirth="09/20/2001";
	public String address="Hyderabad Bapunagar Telangana";
	public String city="Hyderabad";
	public String state="Telangana";
	public String pin="500018";
	public String mobileNumber="9876543210";
	public String newUserPassword="wszxertu";
	public String customerRegistrationPage="Guru99 Bank Customer Registration Page";
	
	
	//Edit Customer
//	98664
	public String customerId="29281";
	public String editCustomerTitle="Guru99 Bank Edit Customer Page";
	public String editCustomerEntryTitle="Guru99 Bank Edit Customer Entry Page";
	public String newPin="345678";
	
	//Delete customer
	public String deleteCustomerTitle="Guru99 Bank Delete Customer Page";
	//add new account
	public String addNewAccountTitle="Guru99 bank add new account";
	public String successRegistration="Gtpl Bank Customer Registration Page";
	//edit account
	public String editAccountTitle="Guru99 Edit Account Page";
	public String accountNumber="127368";
	
	//delete account number
	public String deleteAccountPageTitle="Guru99 Bank Delete Account Page";
	//Random email generation
	public String setRandomEmail() {
		String randomEmail=RandomStringUtils.randomAlphanumeric(5);
		return randomEmail;
	}
			
	
}
