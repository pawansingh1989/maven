package com.company.testclasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.company.util.Excel;

public class Testgoogle
{
	private WebDriver driver;
	private String google;

	@BeforeSuite
	void initialize()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		google="https://www.google.co.in/";
		System.out.println("inside before suite");
	}
	
	@Test(enabled=true)
	public void testgoogle() throws InterruptedException
	{
		System.out.println("inside test");
		Excel excel=new Excel();
		driver.get(google);
		try {
			excel.setExcel(System.getProperty("user.dir")+"\\src\\test\\resources\\data\\test.xls","Sheet1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		for (int i=1;i<2;i++)
		{	for (int j=1;j<2;j++)
			{
				driver.findElement(By.xpath("//input[@id='gbqfq']")).sendKeys(excel.getCellValue(i,j));
				System.out.println("check");
			}
		}
		Thread.sleep(2000);
		
	}
	
	@AfterMethod
	void destroy()
	{
		driver.quit();
	}


}
