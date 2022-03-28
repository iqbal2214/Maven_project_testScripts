package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import crm.com.autodesk.generic.utility.ExcelUtility;
import crm.com.autodesk.generic.utility.FileUtility;
import crm.com.autodesk.generic.utility.JavaUtilities;
import crm.com.autodesk.generic.utility.WebDriverUtility;

public class CreateProductWithMandatoryFieldTest {

	public static void main(String[] args) throws Throwable, IOException {
		JavaUtilities ju=new JavaUtilities();
		ExcelUtility eu=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		FileUtility fu=new FileUtility();
		
		String browser=fu.getPropertyFile("browser");
		String url=fu.getPropertyFile("url");
		String username=fu.getPropertyFile("username");
		String password=fu.getPropertyFile("password");
		
		
		String productname=eu.getExcelProperties("Sheet1", 7, 3);
		
		productname=productname+ju.getRandomNum();
		
		WebDriver driver = wlib.lauchBrowserWithUrl(browser, url);
		
		System.out.println("browser launched successfully");
		
		wlib.waitForPageToLoad(driver,20);
		
		System.out.println("browser launched is "+ browser);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		System.out.println("login successfully");
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String text=driver.findElement(By.className("lvtHeaderText")).getText();
		if(text.contains(productname)) {
		System.out.println("contact creation succesfully");
		}else {
			System.out.println("contact creation failed");
		}
		
		WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.waitForElementToBeClickable(driver, 20, signout);
		wlib.mouseOverToElement(driver, signout);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	
		
		System.out.println("logout successfully");
		
		driver.close();
		
		System.out.println("========browser closed========");
		
	}

}
