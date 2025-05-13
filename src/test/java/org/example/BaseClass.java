package org.example;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.IOException;

public class BaseClass {
	
	public static WebDriver driver;

	@BeforeClass
	public void openbrowser() throws InterruptedException, IOException {
		//open browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		ConfigReader configReader= new ConfigReader();
		String url = String.valueOf(configReader.getProperty("url"));
		System.out.println("*********************"+url);
		driver.get(url);
		System.out.println("chrome launched successfully");

	}
	
	@AfterClass
	public void closebrowser() {
		//close browser
		driver.close();
	}

}
