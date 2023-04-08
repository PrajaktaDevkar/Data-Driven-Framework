
package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListner;


public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListner eventListner;

	
	public TestBase() 
	{
		try {
			prop= new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\praja\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
			}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			}
		catch(IOException e) {
			e.printStackTrace();
			}
	}
	
	public static void initialprop() {
	String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\praja\\OneDrive\\Documents\\Selenium\\ChromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		}
		else if(browsername.equals("firefox")){
		driver= new FirefoxDriver(); 
		}
		
		e_driver=new EventFiringWebDriver(driver);
		 eventListner = new WebEventListner();
		 e_driver.register(eventListner);
		 driver=e_driver;
		
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(TestUtil.implicit_timeout,TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
	
}
