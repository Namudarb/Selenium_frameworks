package datadrivenframework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import datadriven.Datadrivenusingpoi;

public class apachepoi {
	
	List<String> usernamelist = new ArrayList<String>();
	List<String> passwordlist = new ArrayList<String>();
	
	public void excel() throws IOException   {
		
		
		
		FileInputStream excel = new FileInputStream("C:\\Users\\Selenium\\Testdata1.xlsx");
		Workbook workbook = new XSSFWorkbook(excel);
		Sheet sheet =workbook.getSheetAt(0);
		Iterator<Row> rowiterator=sheet.iterator();
		while(rowiterator.hasNext()) {
			Row rowvalue=rowiterator.next();
			Iterator<Cell> cellvalue=rowvalue.iterator();
			int i=2;
			while(cellvalue.hasNext())
		{
			if(i%2==0) {
				usernamelist.add(cellvalue.next().getStringCellValue());
			}
			else {
				passwordlist.add(cellvalue.next().getStringCellValue());
			}
			i++;
		}
		
		}
	}
		
	public void executetest() {
		for (int i=0;i< usernamelist.size();i++) {
			logindetails(usernamelist.get(i),passwordlist.get(i));
		}
	}
		
		
		
		public void logindetails(String uname, String pword) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Selenium\\Chromedriver\\chromedriver.exe");
			WebDriver wd= new ChromeDriver();
			wd.get("https://opensource-demo.orangehrmlive.com/");
			WebElement username = wd.findElement(By.id("txtUsername"));
			username.sendKeys(uname);
			WebElement password = wd.findElement(By.id("txtPassword"));
			password.sendKeys(pword);
			wd.quit();
		}
		
		
	
public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
	apachepoi poi= new apachepoi();
	poi.excel();
	
	poi.executetest();
}
}