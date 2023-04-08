
package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.UsersPage;

import com.crm.qa.util.XLUtility;


public class UsersPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	UsersPage userpage;
	XLUtility xlutil;
	
	
	public UsersPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialprop();
		
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		userpage=homepage.clickuserlink();
		
	}
	
	@DataProvider
	public String[][] getData() throws IOException {
		String filePath="C:\\Users\\praja\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\POMData.xlsx";
		xlutil = new XLUtility(filePath);
		int totalrow = xlutil.getRowCount("Sheet1");
		int totalcell = xlutil.getCellCount("Sheet1", 1);
		
		String data[][]= new String[totalrow][totalcell];
		
		for(int i=1;i<=totalrow;i++) {
			for(int j=0;j<totalcell;j++) {
				
				data[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return data;
	}
	
	@Test(priority=1,dataProvider="getData")
	public void createNewContactTest(String lastName,String firstName,String email,String dept) 
	{
		//userpage.createNewContact("root","joe","joe@a.com","HR & Finance");
		userpage.createNewContact(lastName, firstName, email, dept);
	}
	
	@Test
	public void verifyUsersPageTitleTest() {
		String title = userpage.verifyUsersPageTitle();
		Assert.assertEquals(title.replaceAll("\\s+",""), "actiTIME -  User List ".replaceAll("\\s+",""),"Title does not match");
	}
	
	@Test
	public void verifyUsersPageLogoTest() {
		boolean flag = userpage.verifyUsersPageLogo();
		Assert.assertTrue(flag);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
