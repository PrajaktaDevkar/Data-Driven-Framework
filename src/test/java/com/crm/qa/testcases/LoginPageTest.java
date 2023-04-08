
package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest(){
		super();
	}

	
	
	@BeforeMethod
	public void landingPageTitle() {
	initialprop();
	loginPage= new LoginPage();
	}
	
	@Test(priority=1)
	public void landingPageTitleTest() {
	String pageTitle = loginPage.validateLoginPageTitle();
	System.out.print(pageTitle);
	Assert.assertEquals(pageTitle, "actiTIME - Login");
	}  
	
	@Test(priority=2)
	public void validatelogoTest() {
		boolean flag = loginPage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

