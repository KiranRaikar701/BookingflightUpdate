package com.Factory.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 

{
	
	//This method is used to Initilialize the browser using Thr
	
	public static WebDriver driver;
	
	public static ThreadLocal<WebDriver>tldriver=new ThreadLocal<>();
	public WebDriver  init_driver(String browser)
	{
		System.out.println("Browser value is : " + browser);
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();

			tldriver.set(new FirefoxDriver());

		}
		
		else
		{
			System.out.println("Firefox Launched");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	
	
	public static WebDriver getDriver()
	{
		return tldriver.get();
		
	}
	
	
	
		
	
}

