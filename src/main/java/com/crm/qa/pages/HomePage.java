
package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[@class='profileCell preventPanelsHiding']")
	WebElement userNameLable;

	@FindBy(xpath="//div[text()='Tasks']")
	WebElement tasklink;
	
	@FindBy(xpath="//div[text()='Reports']")
	WebElement reportlink;
	
	@FindBy(xpath="//div[text()='Users']")
	WebElement userlink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePagetitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUsername() {
		return userNameLable.isDisplayed();
	}
	
	public TaskPage clickTasklink() {
		tasklink.click();
		return new TaskPage();
	} 
	
	
	public UsersPage clickuserlink() {
		userlink.click();
		return new UsersPage();
	} 
	
	
	
	
	
	
}
