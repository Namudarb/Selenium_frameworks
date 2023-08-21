package readexcel;

import org.openqa.selenium.By;

public class Excellocators {

	public static By getId(String locatorvalue) {
		return By.id(locatorvalue);
	}
	
	public static By getname(String locatorvalue) {
		return By.name(locatorvalue);
	}
	public static By getcssselector(String locatorvalue) {
		return By.cssSelector(locatorvalue);
	}
	public static By getclassName(String locatorvalue) {
		return By.className(locatorvalue);
			
	}
	public static By getxpath(String locatorvalue) {
		return By.xpath(locatorvalue);
	}
	public static By getlinkText(String locatorvalue) {
		return By.linkText(locatorvalue);
	}
	public static By getpartialLinkText(String locatorvalue) {
		return By.partialLinkText(locatorvalue);
	}
	public static By gettagName(String locatorvalue) {
		return By.tagName(locatorvalue);
	}
	
	
		
}
