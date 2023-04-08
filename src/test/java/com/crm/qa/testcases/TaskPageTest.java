
package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;

public class TaskPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TaskPage taskpage;

	public TaskPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialprop();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		taskpage=homepage.clickTasklink();
	}
	
	@Test(priority=1)
	public void verifyTaskPageTitleTest() {
		String title = taskpage.verifyTaskPageTitle();
		Assert.assertEquals(title.replaceAll("\\s+",""), "actiTIME -  Task List".replaceAll("\\s+",""),"Title does not match");
	}
	
	@Test(priority=2)
	public void verifyCustmerSearchTextboxTest() {
		boolean flag = taskpage.verifyCustmerSearchTextbox();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void searchCustmerByNameTest() throws InterruptedException {
		taskpage.searchCustmerByName("Our company");
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
