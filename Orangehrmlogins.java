package com.learnautomation.keyworddriven_framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import readexcel.Readexcel;


public class Orangehrmlogins {
	public static By locator;
	public static String data;
static	WebDriver driver;
	public static void openBrowser() {
		switch (Readexcel.data){
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			
			 driver = new ChromeDriver();
			break;
		case "Safari":
			WebDriverManager.safaridriver().setup();
			
			 driver = new SafariDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			
			 driver = new EdgeDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			
			 driver = new ChromeDriver();
			break;
		}
	}

	public static void goToURL() throws InterruptedException {
		
		driver.get(Readexcel.data);
		Thread.sleep(1000);
	}
	
	public static void userName() throws InterruptedException {
		 WebElement userName = driver.findElement(Readexcel.locator);
		 userName.sendKeys(Readexcel.data);
		 Thread.sleep(1000);
		 }
	
	public static void Password() throws InterruptedException {
		WebElement Password = driver.findElement(Readexcel.locator);
		 Password.sendKeys(Readexcel.data);
		 Thread.sleep(1000);
		 }
	
	public static void Login() throws InterruptedException {
		WebElement login = driver.findElement(Readexcel.locator);
		 login.click();
		 Thread.sleep(1000);
		 }
	
public static void userProfile() throws InterruptedException {
	WebElement profile = driver.findElement(Readexcel.locator);
	 
	profile.click();
	Thread.sleep(1000);
}
	 
	 public static void logout() throws InterruptedException {
	 WebElement loggingout = driver.findElement(Readexcel.locator);
	 
	 loggingout.click();
	
}

		 

	}


