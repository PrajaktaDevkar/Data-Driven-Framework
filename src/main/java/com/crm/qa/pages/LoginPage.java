package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id="headerContainer")
	WebElement logo;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="pwd") 
	WebElement pass;    
	
	@FindBy(id="loginButton")
	WebElement loginbtn;
	
	//Initializing the page object
	public LoginPage(){
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		return logo.isDisplayed();
	}
	
	
	public HomePage login(String user,String password) throws InterruptedException {
		username.sendKeys(user);
		pass.sendKeys(password);
		loginbtn.click();
		Thread.sleep(2000);
		return new HomePage();
	}
	
	
	
	
}
