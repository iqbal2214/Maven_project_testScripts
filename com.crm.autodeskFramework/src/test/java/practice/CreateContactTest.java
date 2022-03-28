package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import crm.com.autodesk.generic.utility.ExcelUtility;
import crm.com.autodesk.generic.utility.FileUtility;
import crm.com.autodesk.generic.utility.JavaUtilities;
import crm.com.autodesk.generic.utility.WebDriverUtility;

public class CreateContactTest {
	public static void main(String[] args) throws Throwable {
		FileUtility fu=new FileUtility();
		ExcelUtility eu=new ExcelUtility();
		JavaUtilities ju=new JavaUtilities();
		WebDriverUtility wu=new WebDriverUtility();
	
		String BROWSER=fu.getPropertyFile("browser");
		String url=fu.getPropertyFile("url");
		String username=fu.getPropertyFile("username");
		String password=fu.getPropertyFile("password");
		System.out.println(url);
		
		String firstname=eu.getExcelProperties("Sheet1", 4, 3);
		String lastname=eu.getExcelProperties("Sheet1", 5, 3);
		
		lastname=lastname+ju.getRandomNum();
		
		WebDriver driver=wu.lauchBrowserWithUrl(BROWSER, url);
		System.out.println("browser launched successfully");
		
		driver.manage().window().maximize();
		wu.waitForPageToLoad(driver,20);
		
		System.out.println("browser launched is "+ BROWSER);
		
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		System.out.println("login successfully");
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String text=driver.findElement(By.className("dvHeaderText")).getText();
		if(text.contains(lastname)) {
		System.out.println("contact creation succesfully");
		}else {
			System.out.println("contact creation failed");
		}
		
		WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wu.waitForElementToBeClickable(driver, 20, signout);
		wu.mouseOverToElement(driver, signout);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	
		
		System.out.println("logout successfully");
		
		driver.close();
		
		System.out.println("========   closed========");	
	}
}
