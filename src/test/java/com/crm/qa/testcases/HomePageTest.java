
package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TaskPage taskpage;
	
	HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialprop();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title=homepage.verifyHomePagetitle();
		Assert.assertEquals(title.replaceAll("\\s+",""), "actiTIME -  Enter Time-Track".replaceAll("\\s+",""),"Title does not match");
	}
	
	@Test(priority=2)
	public void veriyCorrectUsernameTest() {
		Boolean flag=homepage.verifyCorrectUsername();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyTaskLinkTest() {
		taskpage=homepage.clickTasklink();
	}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
