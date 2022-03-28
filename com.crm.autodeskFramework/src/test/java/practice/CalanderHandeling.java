package practice;

import java.awt.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import crm.com.autodesk.generic.utility.WebDriverUtility;

public class CalanderHandeling {

	public static void main(String[] args) throws Throwable {
		
		LocalDateTime datentime=LocalDateTime.now().plusDays(3);
		 Month month1 = datentime.getMonth();
		 int year=datentime.getYear();
		 int day = datentime.getDayOfMonth();
		 String month= month1.toString();
		 String actualmonth=month.charAt(0)+month.substring(1).toLowerCase();
		 String fromLocation="Ranchi";
		 String toLocation="Chandigarh";
		
		String dateNTime=actualmonth+" "+year; 
		WebDriverUtility wu=new WebDriverUtility();
		WebDriver driver=wu.lauchBrowserWithUrl("chrome", "https://www.makemytrip.com/");
		driver.manage().window().maximize();
		wu.waitForPageToLoad(driver, 4);
		
		Actions act=new Actions(driver);
		act.moveByOffset(20, 20).click().perform();
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		String location="//div[text()='"+dateNTime+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']";
		
		for(;;) 
		try{
		driver.findElement(By.xpath(location)).click();
		break;
		}catch (Exception e){
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();	
		}
		
		driver.findElement(By.cssSelector("[id='fromCity']")).click();
		
		driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys(fromLocation);
		driver.findElement(By.xpath("//div[@id='react-autowhatever-1']/descendant::p[contains(text(),'"+fromLocation+"')]")).click();		
		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(toLocation);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='react-autosuggest__section-container react-autosuggest__section-container--first']/descendant::p[contains(text(),'"+toLocation+"')]")).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();;
		 java.util.List<WebElement> allFlight = driver.findElements(By.xpath("//div[@id='premEcon']/descendant::span[@class='boldFont blackText airlineName']"));
		
		 for(WebElement flight:allFlight) {
			 System.out.println(flight.getText());
		 }
		driver.close();
	}

}
