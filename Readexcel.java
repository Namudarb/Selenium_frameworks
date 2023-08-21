package readexcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import com.learnautomation.keyworddriven_framework.Orangehrmlogins;

public class Readexcel {
	XSSFWorkbook workBook;
	XSSFSheet sheet;
	XSSFCell cell;
	static Method[] function;
	static String keyword;
	static Orangehrmlogins orangehrmmethods;
	static int locatorcolumn = 3;
	static int keywordcolumn = locatorcolumn+1;
	static int datacolumn = locatorcolumn+2;
	static String locators;
	static String locatorname;
	static String locatorvalue;
	static String locatorvalue1;
	static String locatorvalue2;
	public static String data;
	static int totalrows;
	public static By locator;
	public void excelreader(String location) throws IOException {
		FileInputStream file = new FileInputStream(location);
		 workBook = new XSSFWorkbook(file);
		 sheet = workBook.getSheet("Sheet1");
		 totalrows =sheet.getLastRowNum(); 
	}

	public void cellreader (int row, int locatorcolumn, int keywordcolumn, int datacolumn ) {
		locators =sheet.getRow(row).getCell(locatorcolumn).toString().trim();
		if(!locators.equalsIgnoreCase("NA")) {
		locatorname= locators.split("=")[0].toString().trim();
		locatorvalue1= locators.split("=")[1].toString().trim();
		locatorvalue2= locators.split("=")[2].toString().trim();
		locatorvalue = locatorvalue1+"="+locatorvalue2; }
		else { 
			locatorname = "NA";
			locatorvalue = "NA";
		}
		
		keyword= sheet.getRow(row).getCell(keywordcolumn).toString().trim();
		 data = sheet.getRow(row).getCell(datacolumn).toString().trim();
		 System.out.println(locatorname +" : "+ locatorvalue + " keyword" +" : " + keyword+ " data" +" : "+ data );
		
		//String cellvalue= cell.getStringCellValue();
		
	}
	
	
	public void findwebelementstobeused() {
		switch (Readexcel.locatorname) {
		 
		
		case "id":
			 locator =Excellocators.getId(Readexcel.locatorvalue);
			break;
		case "name":	
		locator = Excellocators.getname(Readexcel.locatorvalue);
			break;	
			
		case "className":
			 locator =Excellocators.getclassName(Readexcel.locatorvalue);
			break;
			
		case "cssselector":
			 locator =Excellocators.getcssselector(Readexcel.locatorvalue);
			break;
			
		case "xpath":
			 locator =Excellocators.getxpath(Readexcel.locatorvalue);
			break;
			
		case "tagName":
			 locator =Excellocators.gettagName(Readexcel.locatorvalue);
			break;
			
		case "linkText":
			 locator =Excellocators.getlinkText(Readexcel.locatorvalue);
			break;
			
		case "partiallinkText":
			 locator =Excellocators.getpartialLinkText(Readexcel.locatorvalue);
			break;
	}
	}
	
	
    public static void readorangehrmmethods() {
	 orangehrmmethods = new Orangehrmlogins();
	 function = orangehrmmethods.getClass().getMethods();
 }
    
    public void compareandexecute() throws Exception {
    	for(int i=0;i<=function.length;i++) {
    	if(function[i].getName().equalsIgnoreCase(keyword)) {;
    	function[i].invoke(orangehrmmethods);
    	break;
    }
    	}
    }

public static void main(String[] args)throws Exception {
	
	Readexcel readexcel = new Readexcel();
	readexcel.excelreader("C:\\Users\\karthik\\Desktop\\Narmadha\\ActionKeyword.xlsx");
	 Readexcel.readorangehrmmethods();
	
	
	
	for(int row=1;row<=totalrows;row++) {
		 readexcel.cellreader(row, locatorcolumn, keywordcolumn, datacolumn);
		 readexcel.findwebelementstobeused();
		 readexcel.compareandexecute();
	
	
		
		
		
		/*if(keyword.equalsIgnoreCase("openBrowser")) {
		Orangehrmlogins.openBrowser();
	}
	else if(keyword.equalsIgnoreCase("goToURL")) {
		Orangehrmlogins.goToURL();}
	else if(keyword.equalsIgnoreCase("userName")) {
		Orangehrmlogins.userName();}
	else if(keyword.equalsIgnoreCase("Password")) {
		Orangehrmlogins.Password();}
	else if(keyword.equalsIgnoreCase("Login")) {
		Orangehrmlogins.Login();}
	else if(keyword.equalsIgnoreCase("Logoutbutton")) {
			Orangehrmlogins.Logoutbutton();
		
		}*/
}


}



}

