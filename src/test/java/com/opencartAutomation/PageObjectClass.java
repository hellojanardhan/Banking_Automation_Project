package com.opencartAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectClass {
	public WebDriver driver;
	public PageObjectClass(WebDriver d) {
		driver=d;
		PageFactory.initElements(d,this);
	}
	
	//Login User
	
	@FindBy(name = "uid")
	WebElement userID;
	
	@FindBy(name = "password")
	WebElement Password;
	
	@FindBy(name = "btnLogin")
	WebElement Login;
	
	//logout
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	WebElement logout;
	
	
	//Add new customer
	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	WebElement newCustomer;
	
	@FindBy(name = "name")
	WebElement Name;
	
	@FindBy(xpath = "//body/table[@class='layout']/tbody/tr/td[@colspan='2']/table[@border='0']/tbody/tr[5]/td[2]/input[1]")
	WebElement maleGender;
	
	@FindBy(id = "dob")
	WebElement dateOfBirth;
	
	@FindBy(name = "addr")
	WebElement Address;
	
	@FindBy(name = "city")
	WebElement City;
	
	@FindBy(name = "state")
	WebElement State;
	
	@FindBy(name = "pinno")
	WebElement Pin;
	
	@FindBy(name = "telephoneno")
	WebElement phone;
	
	@FindBy(name = "emailid")
	WebElement Email;
	
	@FindBy(name = "password")
	WebElement newUserPassword;
	
	@FindBy(name = "sub")
	WebElement submit;
	
	//Edit customer
	
	@FindBy(xpath = "//a[contains(text(),'Edit Customer')]")
	WebElement EditCustomer;
	
	@FindBy(name = "cusid")
	WebElement customerID;
	
	@FindBy(name = "AccSubmit")
	WebElement SubmitEditCustomer;
	
	@FindBy(xpath = "//a[@href='DeleteCustomerInput.php']")
	WebElement deleteExistingCustomer;
	
	//add new account
	@FindBy(name = "inideposit")
	WebElement initialDeposit;
	
	@FindBy(name = "button2")
	WebElement addAccount;
	
	//edit account
	@FindBy(xpath = "//a[contains(text(),'Edit Account')]")
	WebElement editAccount;
	
	//delete account
	@FindBy(xpath = "//a[contains(text(),'Delete Account')]")
	WebElement deleteExistingAccount;
	
	@FindBy(name = "accountno")
	WebElement deleteAccountNumber;
	
	//login
	public void setUid(String uid) {
		userID.sendKeys(uid);
	}
	public void setPassword(String password) {
		Password.sendKeys(password);
	}
	
	public void Login() {
		Login.click();
	}
	
	//logout
	public void logout() {
		logout.click();
	}
	//add new customer
	public void addNewCustomer() {
		newCustomer.click();
	}
	public void setName(String name) {
		Name.sendKeys(name);
	}
	public void checkMaleGender() {
		maleGender.click();
	}
	public void setdateOfBirth() {
		dateOfBirth.click();;
	}
	public void setAddress(String address) {
		Address.sendKeys(address);
	}
	public void setCity(String city) {
		City.sendKeys(city);
	}
	public void setState(String state) {
		State.sendKeys(state);
	}
	public void setPin(String pin) {
		Pin.clear();
		Pin.sendKeys(pin);
	}
	public void setPhoneNumber(String phoneNumber) {
		phone.sendKeys(phoneNumber);
	}
	public void setEmail(String email) {
		Email.sendKeys(email);
	}
	public void setNewPassword(String newPassword) {
		newUserPassword.sendKeys(newPassword);
	}
	public void submit() {
		submit.click();
	}
	//edit customer
	public void editCustomer() {
		EditCustomer.click();
	}
	public void ExistingCustomerID(String cusid) {
		customerID.sendKeys(cusid);
	}
	public void accountSubmit() {
		SubmitEditCustomer.click();
	}
	//delete customer
	public void deleteCustomer() {
		deleteExistingCustomer.click();
	}
	
	//add new account
	public void addNewAccount() {
		addAccount.click();
	}
	//edit account
	public void editAccount() {
		editAccount.click();
	}
	
	//delete account
	public void deleteAccount() {
		deleteExistingAccount.click();
	}
	public void deleteAccNumber(String accNumber) {
		deleteAccountNumber.sendKeys(accNumber);
	}
	
}
