package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import crm.com.autodesk.generic.utility.WebDriverUtility;

public class CleartripCalander {
	public static void main(String[] args) throws Throwable {
	String monthNyear="August 2022";
		int day=31;

	WebDriverUtility wu=new WebDriverUtility();
	WebDriver driver=wu.lauchBrowserWithUrl("chrome", "https://www.cleartrip.com/");
	wu.waitForPageToLoad(driver, 2);
	driver.findElement(By.xpath("//*[name()='svg' and @class='t-all ml-2']")).click();
	String location="//div[text()='"+monthNyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::div[text()='"+day+"']";
	
	for(int i=0;i<=20;i++) {
		try {
		driver.findElement(By.xpath(location)).click();
		break;
		
	}catch (Exception e){
		driver.findElement(By.xpath("//*[name()='svg' and @data-testid='rightArrow']")).click();
	}	
	}
	driver.close();	
	}
	}
