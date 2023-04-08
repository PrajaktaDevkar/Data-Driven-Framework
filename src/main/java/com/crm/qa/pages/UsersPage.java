
package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class UsersPage extends TestBase {
	
	@FindBy(xpath="//div[text()='New User']")
	WebElement newUserBtn;
	
	@FindBy(xpath="//span[text()='List of Users']")
	WebElement userPageLogo;
	
	@FindBy(xpath="(//input[@name='lastName'])[2]")
	WebElement lastName;
	
	@FindBy(xpath="(//input[@name='firstName'])[2]")
	WebElement firstName;
	
	@FindBy(xpath="(//input[@name='email'])[2]")
	WebElement emailField;
	
	@FindBy(xpath="//div[@class='simpleListMenuButton components_userGroupSelectorMenu emptyList notEmpty']")
	WebElement deptBtn;
	
	@FindBy(xpath="//div[text()='Save & Send Invitation']")
	WebElement saveBtn;
	
	public UsersPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyUsersPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUsersPageLogo() {
		return userPageLogo.isDisplayed();
	}
	
	
	public void createNewContact(String ftname, String ltName,String email,String dept) {
		newUserBtn.click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);    // Use to handle elementNotInteractableException
		wait1.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(ltName);
		wait1.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(ftname);
		wait1.until(ExpectedConditions.elementToBeClickable(emailField));
		emailField.sendKeys(email);
		wait1.until(ExpectedConditions.elementToBeClickable(deptBtn));
		deptBtn.click();
		WebElement deptOpt=driver.findElement(By.xpath("//div[@class='itemsContainer']//div[text()='"+dept+"']"));
		wait1.until(ExpectedConditions.elementToBeClickable(deptOpt));
		deptOpt.click();
		wait1.until(ExpectedConditions.elementToBeClickable(saveBtn));
		saveBtn.click();
		
		
	}

}
