
package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class TaskPage extends TestBase {

	@FindBy(xpath="(//div[text()='All Customers'])[2]")
	WebElement customersLable;
	
	@FindBy(xpath="(//input[@placeholder='Start typing name ...'])[1]")
	WebElement CustmerSearchTextbox;
	
	public TaskPage()
	{
		PageFactory.initElements(driver, this);
	}	
	
	public String verifyTaskPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCustmerSearchTextbox() {
		return CustmerSearchTextbox.isDisplayed();
	}
	
	public void searchCustmerByName(String name) throws InterruptedException{
		CustmerSearchTextbox.sendKeys(name);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='text']//span[@class='highlightToken']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='titleEditButtonContainer']//div[@class='title']//following-sibling::div[@class='editButton']")).click();
		
	}
	
	
	
	
	
}
