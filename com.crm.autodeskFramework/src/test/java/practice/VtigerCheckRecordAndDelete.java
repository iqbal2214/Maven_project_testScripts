package practice;

import java.awt.AWTException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.ObjectRepository.HomePage;

import crm.com.autodesk.generic.utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerCheckRecordAndDelete {
	public static void main(String[] args) throws AWTException, Throwable {
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver= new ChromeDriver();
		 
		 WebDriverUtility webut=new WebDriverUtility();
		 HomePage home=new HomePage(driver);
		 Random r=new Random();
		 String orgName="devdas"+r.nextInt(1000);
		 System.out.println(orgName);
		 driver.manage().window().maximize();
		 driver.get("http://localhost:8888");
		 
		 driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("root");
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			webut.waitAndClick(driver, home.getOrganizationLink());
			
			List <WebElement> web=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[@onmouseover]/td[3]/a"));
			for(;;) {
			try {
				for(WebElement org:web) {
				driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+orgName+"']")).click();
				break;
			} 
			}catch (Exception e) {
			webut.waitAndClick(driver, driver.findElement(By.xpath("//a[@title='Next']")));
			}	
			}
		//	driver.findElement(By.xpath("//input[@title='Delete [Alt+D]' ]"));	
	}
}

